package com.duobaoyu.demo.integration;

import com.duobaoyu.demo.domain.DemoRequest;
import com.duobaoyu.demo.domain.DemoResponse;
import com.duobaoyu.middleware.common.Result;

/**
 * XXX 集成服务，供业务逻辑层调用<br/>
 * 内部feign调用：此处是对DemoCenterService服务调用的封装，返回Result结果对象<br/>
 * 业务逻辑层根据需要直接取Result结果对象的信息<br/>
 *
 * 此处接口上的泛型仅做抽象说明，不是建议写法（R 代表业务层的请求
 * 传输对象 T 代表返回给业务层的传输对象）
 *
 * @author chengchen
 * @date 2020/8/25
 */
public interface DemoCenterIntegrationService<R,T> {

    /**
     * 调用XXX服务，命名要和对应的feign接口方法名一致,业务层需要关注返回code，返回Result对象
     *
     * @param demo
     *            请求对象
     * @return 返回Result结果
     */
    Result<T> getByDemoWithResult(R demo);

    /**
     * 调用XXX服务，命名要和对应的feign接口方法名一致,业务层不需要关注返回code，直接返回data数据
     *
     * @param demo
     *            请求对象
     * @return 返回结果
     */
    T getByDemo(R demo);
}
