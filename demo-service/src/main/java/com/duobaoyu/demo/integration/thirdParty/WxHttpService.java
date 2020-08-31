package com.duobaoyu.demo.integration.thirdParty;

import com.duobaoyu.demo.domain.TokenRequest;
import com.duobaoyu.demo.domain.TokenResponse;

/**
 * 外部三方服务存放在该目录下,比如以下的微信服务；WxHttpService没有使用代理实现，实现类放到对应目录的impl子目录中
 *
 * @author chengchen
 * @date 2020/8/25
 */
public interface WxHttpService {

    /**
     * 获取外部token
     * 
     * @param request
     *            token请求对象
     * @return token结果
     */
    TokenResponse getToken(TokenRequest request);
}
