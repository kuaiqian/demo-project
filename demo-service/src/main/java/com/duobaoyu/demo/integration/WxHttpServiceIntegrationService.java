package com.duobaoyu.demo.integration;

import com.duobaoyu.demo.domain.TokenRequest;
import com.duobaoyu.demo.domain.TokenResponse;

/**
 * 微信API集成服务,供业务逻辑层调用
 * 调用外部三方服务，序列化和反序列化对象是根据对方接口定义
 *
 * @author chengchen
 * @date 2020/8/25
 */
public interface WxHttpServiceIntegrationService {

    /**
     * 获取外部token
     *
     * @param request
     *            token请求对象
     * @return token结果
     */
    TokenResponse getToken(TokenRequest request);
}
