package com.duobaoyu.demo.integration.impl;

import com.duobaoyu.demo.domain.WxTokenDto;
import com.duobaoyu.middleware.common.Result;
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
    public Result<WxTokenDto> getTokenWithResult(Object request) {
        return getWxTokenDtoResult();
    }

    @Override
    public WxTokenDto getToken(Object request) {
        Result<WxTokenDto> wxTokenDtoResult = getWxTokenDtoResult();
        if (wxTokenDtoResult != null) {
            return wxTokenDtoResult.getData();
        }
        return null;
    }

    /**
     * 调用外部服务接口，例如httpclient、代理服务类等
     * 
     * @return
     */
    private Result<WxTokenDto> getWxTokenDtoResult() {
        TokenRequest tokenRequest = new TokenRequest();
        TokenResponse token = wxHttpService.getToken(tokenRequest);
        WxTokenDto wxTokenDto = new WxTokenDto();
        wxTokenDto.setToken(token.getToken());
        wxTokenDto.setExpireTime(token.getExpireTime());
        return Result.success().data(wxTokenDto).build();
    }
}
