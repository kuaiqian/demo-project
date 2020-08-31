package com.duobaoyu.demo.domain;

import lombok.Data;

/**
 * demo示例，实际情况
 *
 * @author chengchen
 * @date 2020/8/25
 */
@Data
public class DemoRequest {
    /**
     * 请求的唯一标识（具有业务含义，比如订单号、流水号等）；或者能方便定位请求日志的一些信息
     */
    private String msgId;
}
