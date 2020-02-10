package com.shaojie.dubbo.demo.service;

import com.shaojie.dubbo.demo.model.User;

import java.util.List;

/**
 * @author： ShaoJie
 * @data： 2019年12月07日 22:01
 * @Description：
 */
public interface UserService {

    List<User> getUserList(Integer id);

}
