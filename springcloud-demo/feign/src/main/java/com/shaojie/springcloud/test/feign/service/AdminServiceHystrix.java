package com.shaojie.springcloud.test.feign.service;

import org.springframework.stereotype.Component;

/**
 * @author ShaoJie
 * @Date 2019/11/6
 */
@Component
public class AdminServiceHystrix implements AdminService {

    @Override
    public String sayHi(String message) {
        return "Hi，your message is :\"" + message + "\" but request error.";
    }
}
