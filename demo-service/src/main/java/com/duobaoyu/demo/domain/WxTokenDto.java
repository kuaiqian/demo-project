package com.duobaoyu.demo.domain;

import lombok.Data;

/**
 * 微信token 传输对象（如果仅是应用内部使用，放在domain目录下，如果是需要暴露给外部，放到api模块下）
 *
 * @author chengchen
 * @date 2020/9/1
 */
@Data
public class WxTokenDto {
    /**
     * token 值
     */
    private String token;

    /**
     * token失效时间，单位：秒
     */
    private Integer expireTime;
}
