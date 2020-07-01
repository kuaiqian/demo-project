package com.duobaoyu.demoproject.service.impl;

import com.duobaoyu.demoproject.enums.ErrorCodesEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.duobaoyu.demoproject.exception.AppBizException;
import com.duobaoyu.demoproject.service.DemoService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chengchen
 * @version 1.0
 * @date 2020/7/1 15:54
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Override
    public void doDemo(String demo) {
        if (StringUtils.isBlank(demo)) {
            //预检查业务异常，不需要打印日志
            throw new AppBizException(ErrorCodesEnum.TEMPLATE_NO_NUll.getCode(),ErrorCodesEnum.TEMPLATE_NO_NUll.getMessage());
        }

        try {
            //与外部交互等操作，网络超时异常等

        } catch (RuntimeException e) {
            //非预检查的异常，必须打印日志堆栈信息
            log.error("发生异常，参数：{}",demo,e);
            //看业务要求是否需要捕获转换为自定义异常，不需要转换为自定义异常，则直接抛出
            throw new AppBizException(ErrorCodesEnum.REQUEST_CHANNEL_ERROR.getCode(),ErrorCodesEnum.REQUEST_CHANNEL_ERROR.getMessage());
        }
    }
}
