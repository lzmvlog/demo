package com.shaojie.springcloud.test.feign.controller;

import com.shaojie.springcloud.test.feign.service.AdminServiceHystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShaoJie
 * @Date 2019/11/6
 */
@RestController
public class AdminFeignController {

//    @Autowired
//    private AdminFeignService adminService;

    @Autowired
    private AdminServiceHystrix adminService;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String message) {
        return adminService.sayHi(message);
    }

}
