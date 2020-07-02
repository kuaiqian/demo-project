package com.duobaoyu.demoproject.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.duobaoyu.middleware.common.Result;

import io.swagger.annotations.ApiOperation;

/**
 * XXXX描述接口功能
 *
 * @author chengchen
 * @version 1.0
 * @date 2020/5/19 10:13
 */
@FeignClient("democenter")
public interface DemoCenterService {

    @GetMapping(value = "/demo/getByDemo.do")
    @ApiOperation(value = "XXXX接口方法描述")
    Result<Void> getByDemo(Object demo);
}
