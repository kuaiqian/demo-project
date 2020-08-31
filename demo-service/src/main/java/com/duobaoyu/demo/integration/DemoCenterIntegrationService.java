package com.duobaoyu.demo.integration;

import com.duobaoyu.demo.domain.DemoRequest;
import com.duobaoyu.demo.domain.DemoResponse;
import com.duobaoyu.middleware.common.Result;

/**
 * XXX 集成服务，供业务逻辑层调用
 * 内部feign调用：此处是对DemoCenterService服务调用的封装，返回Result结果对象
 * 业务逻辑层根据需要直接取Result结果对象的信息
 *
 * @author chengchen
 * @date 2020/8/25
 */
public interface DemoCenterIntegrationService {

    /**
     * 调用XXX服务，命名要和对应的接口方法名一致
     * 业务逻辑层
     * 
     * @param demo
     * @return
     */
    Result<DemoResponse> getByDemo(DemoRequest demo);
}


