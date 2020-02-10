package com.shaojie.springcloud.test.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author ShaoJie
 * @Date 2019/11/6
 */
@SpringBootApplication
//@EnableDiscoveryClient
// 如果是使用 eureka 注册中心推荐使用 @EnableEurekaClient
// 如果是使用别的 注册中心 推荐使用 @EnableDiscoveryClient
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
