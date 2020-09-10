package com.duobaoyu.demo.integration;

import com.duobaoyu.demo.domain.WxTokenDto;
import com.duobaoyu.middleware.common.Result;

/**
 * 微信API集成服务,供业务逻辑层调用 调用外部三方服务，序列化和反序列化对象是根据对方接口定义
 *
 * @author chengchen
 * @date 2020/8/25
 */
public interface WxHttpServiceIntegrationService {

    /**
     * 获取外部token,业务层需要知道外部返回错误信息时，返回Result对象
     *
     * @param request
     *            token请求对象
     * @return token结果
     */
    Result<WxTokenDto> getTokenWithResult(Object request);

    /**
     * 获取外部token，业务层不需要知道外部返回错误信息时，直接返回data数据
     *
     * @param request
     * @return
     */
    WxTokenDto getToken(Object request);
}
