package com.shaojie.springcloud.test.user.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ShaoJie
 * @Date 2019/11/6
 */
@Configuration
public class UserConfiguration {

    @Bean
    @LoadBalanced
    // @LoadBalanced 负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // @LoadBalanced 加上这个注解 会导致  eurekaclient 获取 服务实例失败

}
