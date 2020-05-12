package com.shaojie.spring.cloud.alibaba.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShaoJie
 * @Date 2019/11/11
 */
@RestController
public class NacoConfigController {

    @Value("${name}")
    String name;

    @GetMapping("advice")
    public String advice() {
        return name;
    }

}
