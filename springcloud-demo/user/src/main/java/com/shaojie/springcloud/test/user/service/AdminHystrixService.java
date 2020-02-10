package com.shaojie.springcloud.test.user.service;

import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ShaoJie
 * @Date 2019/11/6
 */
@Service
public class AdminHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("eurekaClient")
    private EurekaClient eurekaClient;

    // 正常的服务使用熔断
//    @HystrixCommand(fallbackMethod = "hiError")
//    public String sayHi(String message) {
//        return restTemplate.getForObject( eurekaClient.getNextServerFromEureka("ORDER",false).getHomePageUrl() + "hi?message=" + message, String.class);
//    }

    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHi(String message) {
        return restTemplate.getForObject( "http://ORDER:8050/hi?message=" + message, String.class);
    }

    public String hiError(String message) {
        return "Hi，your message is :" + message + " but request error.";
    }

}
