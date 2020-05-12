package com.shaojie.springcloud.test.user.service;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ShaoJie
 * @Date 2019/11/6
 */
@Service
public class AdminService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("eurekaClient")
    private EurekaClient eurekaClient;

//    public String sayHi(String message){
//        return restTemplate.getForObject( eurekaClient.getNextServerFromEureka("ORDER",false).getHomePageUrl() + "/hi?message=" + message,String.class);
//    }

    public String sayHi(String message) {
        return restTemplate.getForObject("http://ORDER:8050/hi?message=" + message, String.class);
//        return restTemplate.getForObject( "http://localhost:8050/hi?message=" + message,String.class);
    }

}
