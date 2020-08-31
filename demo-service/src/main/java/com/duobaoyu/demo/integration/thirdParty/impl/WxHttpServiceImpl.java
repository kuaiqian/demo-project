package com.duobaoyu.demo.integration.thirdParty.impl;

import org.springframework.stereotype.Service;

import com.duobaoyu.demo.domain.TokenRequest;
import com.duobaoyu.demo.domain.TokenResponse;
import com.duobaoyu.demo.integration.thirdParty.WxHttpService;

/**
 * @author chengchen
 * @date 2020/8/25
 */
@Service
public class WxHttpServiceImpl implements WxHttpService {
    @Override
    public TokenResponse getToken(TokenRequest request) {
        //比如调用三方的SDK或者自行使用httpclient工具类等请求远程服务
        return null;
    }
}
