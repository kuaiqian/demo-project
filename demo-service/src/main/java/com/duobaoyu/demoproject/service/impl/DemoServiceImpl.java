package com.duobaoyu.demoproject.service.impl;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.duobaoyu.demoproject.enums.ErrorCodesEnum;
import com.duobaoyu.demoproject.exception.AppBizException;
import com.duobaoyu.demoproject.feign.DemoCenterService;
import com.duobaoyu.demoproject.service.DemoService;
import com.duobaoyu.middleware.common.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * demo服务,描述清楚类
 *
 * @author chengchen
 * @version 1.0
 * @date 2020/7/1 15:54
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoCenterService demoCenterService;

    @Override
    public void doDemo(Object demo) {
        return;
    }

    @Override
    public String getDemo(Object demo) {
        if (Objects.isNull(demo)) {
            // 预检查业务异常，不需要打印日志
            throw new AppBizException(ErrorCodesEnum.TEMPLATE_NO_NUll.getCode(),
                ErrorCodesEnum.TEMPLATE_NO_NUll.getMessage());
        }

        if (StringUtils.length(demo.toString())>3) {
            // 预检查业务异常，需要打印日志
            log.warn("XXX错误：{}，{}",ErrorCodesEnum.TEMPLATE_NO_NUll.getCode(),ErrorCodesEnum.TEMPLATE_NO_NUll.getMessage());
            throw new AppBizException(ErrorCodesEnum.TEMPLATE_NO_NUll.getCode(),
                    ErrorCodesEnum.TEMPLATE_NO_NUll.getMessage());
        }

        try {
            // feign调用或者与外部系统交互时，打印请求和相应的关键参数
            log.info("请求demoCenter参数：{}", demo);
            Result<Void> result = demoCenterService.getByDemo(demo);
            log.info("请求demoCenter结果：{}", JSON.toJSONString(result));

            // result 结果为空,是否需要转化为业务异常
            if (result == null) {
                log.warn("远程服务调用异常，{}，{}", ErrorCodesEnum.REMOTE_SERVICE_ERROR.getCode(),
                    ErrorCodesEnum.REMOTE_SERVICE_ERROR.getMessage());
                throw new AppBizException(ErrorCodesEnum.REMOTE_SERVICE_ERROR.getCode(),
                    ErrorCodesEnum.REMOTE_SERVICE_ERROR.getMessage());
            }

            if (result != null && result.isSuccess()) {
                // do something 成功处理逻辑
            } else {
                //do something  失败处理逻辑
            }
        } catch (RuntimeException e) {
            // 非预检查的异常，必须打印日志堆栈信息
            log.error("请求demoCenter发生异常，参数：{}", demo, e);
            // 看业务要求是否需要捕获转换为自定义异常，不需要转换为自定义异常，则直接抛出
            throw new AppBizException(ErrorCodesEnum.REQUEST_CHANNEL_ERROR.getCode(),
                ErrorCodesEnum.REQUEST_CHANNEL_ERROR.getMessage());
        }
        return null;
    }
}
