package com.shaojie.dubbo.demo.controller;

import com.shaojie.dubbo.demo.model.User;
import com.shaojie.dubbo.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author： ShaoJie
 * @data： 2019年12月09日 21:09
 * @Description：
 */
@Controller
public class OrderController {

    @Autowired
//    @Reference // 引用服务
    private OrderService orderService;

    @ResponseBody
    @GetMapping("/init/{id}")
    public List<User> initOrder(@PathVariable(value = "id") Integer id){
        return orderService.initOrder(id);
    }

}
