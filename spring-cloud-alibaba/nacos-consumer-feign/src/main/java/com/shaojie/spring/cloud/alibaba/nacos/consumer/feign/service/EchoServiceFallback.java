package com.shaojie.spring.cloud.alibaba.nacos.consumer.feign.service;

import org.springframework.stereotype.Component;

/**
 * @author ShaoJie
 * @Date 2019/11/11
 */
@Component
public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(String message) {
        return "echo fallback";
    }

}
