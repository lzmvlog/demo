package com.shaojie.dubbo.demo.service.impl;

import com.shaojie.dubbo.demo.model.User;
import com.shaojie.dubbo.demo.service.OrderService;
import com.shaojie.dubbo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： ShaoJie
 * @data： 2019年12月07日 22:12
 * @Description：
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;

    public List<User> initOrder(Integer id) {
        System.out.println("用户的id:" + id);
        // 查询用户的信息
        List<User> userList = userService.getUserList(id);
        for (User u : userList) {
            System.out.println(u.toString());
        }
        // 按任意键退出
//        System.in.read();
        return userList;
    }

}
