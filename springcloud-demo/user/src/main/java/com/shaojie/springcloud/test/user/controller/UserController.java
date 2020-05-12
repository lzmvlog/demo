package com.shaojie.springcloud.test.user.controller;

import com.shaojie.springcloud.test.user.service.AdminHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShaoJie
 * @Date 2019/11/6
 */
@RestController
public class UserController {

//    @Autowired
//    private AdminService adminService;

    @Autowired
    private AdminHystrixService adminService;

    @GetMapping("sayHi")
    public String sayHi(String message) {
        return adminService.sayHi(message);
    }


}
