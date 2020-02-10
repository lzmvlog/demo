package com.shaojie.dubbo.demo.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shaojie.dubbo.demo.model.User;
import com.shaojie.dubbo.demo.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author： ShaoJie
 * @data： 2019年12月09日 21:14
 * @Description：
 */
@Service
// 注意： dubbo 的 @Service 暴露服务
@Component
public class UserServiceImpl implements UserService {

    @HystrixCommand
    public List<User> getUserList(Integer id) {
        ArrayList<User> users = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        user.setName("ShaoJie");
        user.setDate(new Date());
        users.add(user);
        return users;
    }
}
