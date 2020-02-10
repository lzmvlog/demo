package com.shaojie.dubbo.demo.service.impl;

import com.shaojie.dubbo.demo.model.User;
import com.shaojie.dubbo.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author： ShaoJie
 * @data： 2019年12月07日 22:01
 * @Description：
 */
@Service
public class UserServiceImpl implements UserService {

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
