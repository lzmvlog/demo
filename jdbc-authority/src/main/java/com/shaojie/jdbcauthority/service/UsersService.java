package com.shaojie.jdbcauthority.service;

import com.shaojie.jdbcauthority.model.Users;

/**
 * @author： ShaoJie
 * @data： 2020年01月11日 12:36
 * @Description： 用户的业务逻辑层
 */
public interface UsersService {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    Users getUsersInfoByUserName(String username);
}
