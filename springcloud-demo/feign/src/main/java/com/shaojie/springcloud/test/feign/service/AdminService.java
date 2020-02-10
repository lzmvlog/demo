package com.shaojie.springcloud.test.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ShaoJie
 * @Date 2019/11/6
 */
@FeignClient(value = "ORDER", fallback = AdminServiceHystrix.class)
public interface AdminService {

    // feign 下使用熔断器
   @GetMapping("hi")
   String sayHi(@RequestParam(value = "message") String message);

}
