package com.shaojie.authority.dao;

import com.shaojie.authority.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ShaoJie
 * @Date 2019年11月25 18:46
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 根据用户的账号查询用户
     *
     * @param name 用户的账号
     * @return 用户信息
     */
    User findUserByName(String name);
}
