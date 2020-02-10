package com.shaojie.authority.service;

import com.shaojie.authority.model.User;

/**
 * @author ShaoJie
 * @Date 2019年11月25 18:49
 * @Description:
 */
public interface UserService {

    /**
     * 根据用户的账号查询用户
     *
     * @param name 用户的账号
     * @return 用户信息
     */
    User findUserByName(String name);
}
