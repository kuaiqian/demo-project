package com.duobaoyu.demo.integration.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.duobaoyu.demo.domain.DemoRequest;
import com.duobaoyu.demo.domain.DemoResponse;
import com.duobaoyu.middleware.common.Result;

import io.swagger.annotations.ApiOperation;

/**
 * 内部feign调用放到该子目录中；feign客户端采用动态代理实现，没有实现类，如果有实现类，需要将实现类放到impl子目录
 *
 * XXXX描述接口功能
 *
 * @author chengchen
 * @version 1.0
 * @date 2020/5/19 10:13
 */
@FeignClient("democenter")
public interface DemoCenterService {

    @GetMapping(value = "/com/duobaoyu/demo/getByDemo.do")
    @ApiOperation(value = "XXXX接口方法描述")
    Result<DemoResponse> getByDemo(DemoRequest demo);
}
