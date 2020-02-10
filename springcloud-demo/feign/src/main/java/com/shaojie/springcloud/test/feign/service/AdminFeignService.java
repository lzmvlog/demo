package com.shaojie.springcloud.test.feign.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ShaoJie
 * @Date 2019/11/6
 */
//@FeignClient(value = "ORDER")
public interface AdminFeignService {

    @GetMapping("hi")
    String sayHi(@RequestParam(value = "message") String message);
//    String sayHi(String message);

}
