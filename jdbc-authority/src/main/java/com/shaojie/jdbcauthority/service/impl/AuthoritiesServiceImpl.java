//package com.shaojie.jdbcauthority.service.impl;
//
//import com.shaojie.jdbcauthority.dao.AuthoritiesMapper;
//import com.shaojie.jdbcauthority.model.Authorities;
//import com.shaojie.jdbcauthority.service.AuthoritiesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * @author： ShaoJie
// * @data： 2020年01月11日 13:46
// * @Description： 权限 业务逻辑层
// */
//@Service
//@Transactional
//public class AuthoritiesServiceImpl implements AuthoritiesService {
//
//    /**
//     * 权限的数据访问层
//     */
//    @Autowired
//    private AuthoritiesMapper authoritiesMapper;
//
//    /**
//     * 根据用户名 查询用户角色
//     *
//     * @param username 用户名
//     * @return 返回用户角色集合
//     */
//    @Override
//    public List<Authorities> getUserAuthorities(String username) {
//        return authoritiesMapper.getUserAuthorities(username);
//    }
//}
