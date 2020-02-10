package com.shaojie.spring.cloud.alibaba.nacos.consumer.feign.controller;

import com.shaojie.spring.cloud.alibaba.nacos.consumer.feign.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShaoJie
 * @Date 2019/11/8
 */
@RestController
public class NacosConsumerFeignController {

    @Autowired
    private EchoService echoService;

    @GetMapping(value = "/echo/hi")
    public String echo() {
        return echoService.echo("Spring Cloud Alibaba Hi Feign");
    }

}
