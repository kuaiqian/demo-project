package com.duobaoyu.demo.integration.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duobaoyu.demo.domain.TokenRequest;
import com.duobaoyu.demo.domain.TokenResponse;
import com.duobaoyu.demo.integration.WxHttpServiceIntegrationService;
import com.duobaoyu.demo.integration.thirdParty.WxHttpService;

/**
 * @author chengchen
 * @date 2020/8/25
 */
@Service
public class WxHttpServiceIntegrationServiceImpl implements WxHttpServiceIntegrationService {
    @Autowired
    private WxHttpService wxHttpService;

    @Override
    public TokenResponse getToken(TokenRequest request) {
        return null;
    }
}
