package com.duobaoyu.demo.domain;

import lombok.Data;

/**
 * token 请求对象
 *
 * @author chengchen
 * @date 2020/8/25
 */
@Data
public class TokenRequest {

    /**
     * 微信公众号的appid
     */
    private String appid;

    /**
     * 微信公众号的appsecret
     */
    private String secret;

    /**
     * 授权类型
     */
    private String grantType;
}
