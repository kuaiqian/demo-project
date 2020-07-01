package com.duobaoyu.demoproject;

import com.duobaoyu.demoproject.util.ErrorUtil;
import com.duobaoyu.middleware.common.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ControllerAdvice
@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
public class DemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
    }

    /**
     * 全局异常处理
     *
     * @param ex Exception
     * @return R
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> defaultExceptionHandler(Exception ex) {
        return ErrorUtil.handException(ex);
    }
}
