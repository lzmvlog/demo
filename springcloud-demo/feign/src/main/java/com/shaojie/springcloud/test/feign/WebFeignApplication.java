package com.shaojie.springcloud.test.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ShaoJie
 * @Date 2019/11/6
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class WebFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebFeignApplication.class,args);
    }
}
