package com.shaojie.springcloud.test.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ShaoJie
 * @Date 2019/11/6
 */
@SpringBootApplication
@EnableEurekaServer
// @EnableEurekaServer 表明这是一个 eureka 的服务
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
