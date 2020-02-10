package com.shaojie.authority.service.impl;

import com.shaojie.authority.dao.UserRepository;
import com.shaojie.authority.model.User;
import com.shaojie.authority.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ShaoJie
 * @Date 2019年11月25 18:49
 * @Description:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * 用户 数据访问层
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * 根据用户的账号查询用户
     *
     * @param name 用户的账号
     * @return 用户信息
     */
    @Override
    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }
}
