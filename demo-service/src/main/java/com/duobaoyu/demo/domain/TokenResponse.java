package com.duobaoyu.demo.domain;

import lombok.Data;

/**
 * token结果对象，接口返回结果的反序列化对象
 *
 * @author chengchen
 * @date 2020/8/25
 */
@Data
public class TokenResponse {

    /**
     * 微信出错返回码，为0表示成功，非0表示调用失败
     */
    private String errcode;

    /**
     * 微信返回码提示语
     */
    private String errmsg;
    /**
     * 令牌
     */
    private String token;

    /**
     * 有效期（单位：秒）
     */
    private Integer expireTime;
}
