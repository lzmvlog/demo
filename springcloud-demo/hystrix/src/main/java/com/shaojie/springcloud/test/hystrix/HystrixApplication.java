package com.shaojie.springcloud.test.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author ShaoJie
 * @Date 2019/11/6
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
// 这里的启动熔断器不是指单独开启熔断
public class HystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class,args);
    }
}
