package com.duobaoyu.demo.integration.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.duobaoyu.demo.domain.DemoRequest;
import com.duobaoyu.demo.domain.DemoResponse;
import com.duobaoyu.demo.enums.ErrorCodesEnum;
import com.duobaoyu.demo.integration.DemoCenterIntegrationService;
import com.duobaoyu.demo.integration.feign.DemoCenterService;
import com.duobaoyu.middleware.common.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * demoCenter集成服务实现类
 *
 * @author chengchen
 * @date 2020/8/25
 */
@Service
@Slf4j
public class DemoIntegrationServiceImpl implements DemoCenterIntegrationService<DemoRequest, DemoResponse> {

    @Autowired
    private DemoCenterService demoCenterService;

    @Override
    public Result<DemoResponse> getByDemoWithResult(DemoRequest demo) {
        Result<DemoResponse> demoResponseResult = getDemoResponseResult(demo);
        return demoResponseResult;
    }

    @Override
    public DemoResponse getByDemo(DemoRequest demo) {
        Result<DemoResponse> byDemoWithResult = getByDemoWithResult(demo);
        if (byDemoWithResult != null) {
            return byDemoWithResult.getData();
        }
        return null;
    }

    /**
     * 获取demo结果
     *
     * @param demo
     *            请求参数对象
     * @return 返回结果
     */
    private Result<DemoResponse> getDemoResponseResult(DemoRequest demo) {
        try {
            if (log.isInfoEnabled()) {
                // 请求出口关键日志，注意日志大小和敏感字段（如对象中存在大的集合字段，建议覆写请求对象toString方法，只答应关键字段；敏感字段如卡号等 要做脱敏处理）
                log.info("请求demoCenter参数：{}", JSON.toJSONString(demo));
            }
            DemoRequest demoRequest = new DemoRequest();
            Result<DemoResponse> demoResponseResult = demoCenterService.getByDemo(demoRequest);
            if (log.isInfoEnabled()) {
                // 响应结果入口关键日志，注意日志大小和敏感字段（如对象中存在大的集合字段，建议覆写请求对象toString方法，只答应关键字段；敏感字段如卡号等 要做脱敏处理）
                log.info("请求demoCenter结果：{}", JSON.toJSONString(demoResponseResult));
            }
            if (demoResponseResult == null) {
                // 返回空result对象
                log.warn("远程服务调用异常，{}，{}", ErrorCodesEnum.REMOTE_SERVICE_ERROR.getCode(),
                    ErrorCodesEnum.REMOTE_SERVICE_ERROR.getMessage());
                return Result.failure().code(ErrorCodesEnum.REMOTE_SERVICE_ERROR.getCode())
                    .message(ErrorCodesEnum.REMOTE_SERVICE_ERROR.getMessage()).build();
            }
            // 这里可以对结果对象做一些公共逻辑的处理，然后返回
            return demoResponseResult;
        } catch (Exception e) {
            // 日志中占位符代表该次请求的现场信息，需要打印有用的业务信息（注意敏感字段不要打印或者脱敏打印），e是异常堆栈,不要打印e.getMessage()
            log.error("调用XXX服务异常,XXX:{}", demo.getMsgId(), e);
            // 定义一个应用自己的远程调用异常码
            return Result.failure().code(ErrorCodesEnum.REMOTE_SERVICE_ERROR.getCode())
                .message(ErrorCodesEnum.REMOTE_SERVICE_ERROR.getMessage()).build();
        }
    }
}
