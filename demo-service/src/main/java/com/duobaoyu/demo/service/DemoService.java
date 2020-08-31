package com.duobaoyu.demo.service;

/**
 * demo服务,描述清楚接口作用
 *
 * @author chengchen
 * @version 1.0
 * @date 2020/7/1 15:52
 */
public interface DemoService {

    /**
     * 方法描述信息
     * 
     * @param demo
     *            参数说明
     *
     */
    void doDemo(Object demo);

    /**
     * 方法描述信息
     * 
     * @param demo
     *            参数说明
     * @return 返回值说明,什么时候返回空值等
     */
    String getDemo(Object demo);
}
