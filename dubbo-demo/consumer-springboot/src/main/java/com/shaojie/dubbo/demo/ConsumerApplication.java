package com.shaojie.dubbo.demo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author： ShaoJie
 * @data： 2019年12月09日 19:22
 * @Description： 依赖 springboot 的 dubbo 架构的服务消费者
 */
// 开启基于注解的 dubbo 服务
@EnableDubbo
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
