package com.shaojie.jdbcauthority.service;

import com.shaojie.jdbcauthority.model.Authorities;

import java.util.List;

/**
 * @author： ShaoJie
 * @data： 2020年01月11日 13:46
 * @Description：
 */
public interface AuthoritiesService {

    /**
     * 根据用户名 查询用户角色
     *
     * @param username 用户名
     * @return 返回用户角色集合
     */
    List<Authorities> getUserAuthorities(String username);
}
