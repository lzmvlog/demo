package com.shaojie.dubbo.demo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author： ShaoJie
 * @data： 2019年12月09日 19:29
 * @Description： 依赖 springboot 的 dubbo 架构的服务提供者
 * <p>
 * 步骤：
 * 1、导入依赖
 * dubbo-spring-boot-starter
 * 2、 dubbo 其余依赖
 */
// 开启容错
@EnableHystrix
// 开启基于注解的 dubbo 服务
@EnableDubbo
// 基于xml 配置文件整合 dubbo
//@ImportResource("classpath:/*.xml")
@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
