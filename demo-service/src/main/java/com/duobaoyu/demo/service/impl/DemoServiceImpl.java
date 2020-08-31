package com.duobaoyu.demo.service.impl;

import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.duobaoyu.demo.domain.DemoRequest;
import com.duobaoyu.demo.domain.DemoResponse;
import com.duobaoyu.demo.enums.ErrorCodesEnum;
import com.duobaoyu.demo.exception.AppBizException;
import com.duobaoyu.demo.integration.DemoCenterIntegrationService;
import com.duobaoyu.demo.integration.feign.DemoCenterService;
import com.duobaoyu.demo.mapper.res_demo.manual.DemoMapperExt;
import com.duobaoyu.demo.service.DemoService;
import com.duobaoyu.middleware.common.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * demo服务,描述清楚类作用
 *
 * @author chengchen
 * @version 1.0
 * @date 2020/7/1 15:54
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {
    @Resource
    private DemoMapperExt demoMapperExt;

    @Autowired
    private DemoCenterService demoCenterService;

    @Autowired
    private DemoCenterIntegrationService demoCenterIntegrationService;

    /**
     * 没有集成层服务的写法，参考如下
     * 
     * @param demo
     */
    @Override
    public void doDemo(Object demo) {
        {
            if (Objects.isNull(demo)) {
                // 预检查业务异常，不需要打印日志
                throw new AppBizException(ErrorCodesEnum.TEMPLATE_NO_NUll.getCode(),
                    ErrorCodesEnum.TEMPLATE_NO_NUll.getMessage());
            }

            if (StringUtils.length(demo.toString()) > 3) {
                // 预检查业务异常，需要打印日志
                log.warn("XXX错误：{}，{}", ErrorCodesEnum.TEMPLATE_NO_NUll.getCode(),
                    ErrorCodesEnum.TEMPLATE_NO_NUll.getMessage());
                throw new AppBizException(ErrorCodesEnum.TEMPLATE_NO_NUll.getCode(),
                    ErrorCodesEnum.TEMPLATE_NO_NUll.getMessage());
            }

            try {
                if (log.isInfoEnabled()) {
                    // 请求出口关键日志，注意日志大小和敏感字段（如对象中存在大的集合字段，建议覆写请求对象toString方法，只打印关键字段；敏感字段如卡号等要做脱敏处理）
                    log.info("请求demoCenter参数：{}", JSON.toJSONString(demo));
                }
                // 组装请求参数
                DemoRequest demoRequest = new DemoRequest();
                Result<DemoResponse> result = demoCenterService.getByDemo(demoRequest);
                if (log.isInfoEnabled()) {
                    // 响应结果入口关键日志，注意日志大小和敏感字段（如对象中存在大的集合字段，建议覆写请求对象toString方法，只答应关键字段；敏感字段如卡号等 要做脱敏处理）
                    log.info("请求demoCenter结果：{}", JSON.toJSONString(demoRequest));
                }
                // result 结果为空,是否需要转化为业务异常
                if (result == null) {
                    log.warn("远程服务调用异常，{}，{}", ErrorCodesEnum.REMOTE_SERVICE_ERROR.getCode(),
                        ErrorCodesEnum.REMOTE_SERVICE_ERROR.getMessage());
                    throw new AppBizException(ErrorCodesEnum.REMOTE_SERVICE_ERROR.getCode(),
                        ErrorCodesEnum.REMOTE_SERVICE_ERROR.getMessage());
                }
            } catch (RuntimeException e) {
                // 非预检查的异常，必须打印日志堆栈信息
                log.error("请求demoCenter发生异常，参数：{}", demo, e);
                // 看业务要求是否需要捕获转换为自定义异常，不需要转换为自定义异常，则直接抛出
                throw new AppBizException(ErrorCodesEnum.REQUEST_CHANNEL_ERROR.getCode(),
                    ErrorCodesEnum.REQUEST_CHANNEL_ERROR.getMessage());
            }
        }
    }

    /**
     * 有集成层服务的写法，参考如下；服务调用异常处理和响应结果处理下沉到integration层 业务逻辑层不需要异常捕获处理，逻辑更加清晰简洁
     * 
     * @param demo
     *            请求参数
     */
    @Override
    public String getDemo(Object demo) {
        if (Objects.isNull(demo)) {
            // 预检查业务异常，不需要打印日志
            throw new AppBizException(ErrorCodesEnum.TEMPLATE_NO_NUll.getCode(),
                ErrorCodesEnum.TEMPLATE_NO_NUll.getMessage());
        }

        if (StringUtils.length(demo.toString()) > 3) {
            // 预检查业务异常，需要打印日志
            log.warn("XXX错误：{}，{}", ErrorCodesEnum.TEMPLATE_NO_NUll.getCode(),
                ErrorCodesEnum.TEMPLATE_NO_NUll.getMessage());
            throw new AppBizException(ErrorCodesEnum.TEMPLATE_NO_NUll.getCode(),
                ErrorCodesEnum.TEMPLATE_NO_NUll.getMessage());
        }

        // 组装请求参数
        DemoRequest demoRequest = new DemoRequest();
        Result<DemoResponse> result = demoCenterIntegrationService.getByDemo(demoRequest);

        // 如果业务流程需要根据远程调用某些响应码做特殊处理,例如调用接口异常（可能是超时异常，或者底层框架异常，对方结果状态不明确，这时需要延迟查询）
        if (ErrorCodesEnum.REMOTE_SERVICE_ERROR.getCode().equals(result.getCode())) {
            // 发送延迟消息等
            return null;
        }

        if (result != null && result.getData() != null) {
            // do something 有返回数据的处理逻辑
        }
        return null;
    }
}
