//package com.shaojie.jdbcauthority.service.impl;
//
//import com.shaojie.jdbcauthority.dao.UsersMapper;
//import com.shaojie.jdbcauthority.model.Authorities;
//import com.shaojie.jdbcauthority.model.Users;
//import com.shaojie.jdbcauthority.service.UsersService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author： ShaoJie
// * @data： 2020年01月11日 12:37
// * @Description： 用户的 业务逻辑层
// */
//@Service
//@Transactional
//@Slf4j
//public class UsersServiceImpl implements UserDetailsService, UsersService {
//
//    /**
//     * 用户的 数据访问层
//     */
//    private UsersMapper usersMapper;
//
//    /**
//     * 权限的业务逻辑层
//     */
//    private AuthoritiesServiceImpl authoritiesService;
//
//    /**
//     * 密码加密
//     */
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    /**
//     * 根据用户名 来查询用户的信息
//     *
//     * @param username 用户名
//     * @return 用户信息
//     * @throws UsernameNotFoundException 用户不存在
//     */
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        log.info("{ 当前登录的用户账号：  {} }", username);
//        // 权限集合 当前用户所具有的权限
//        List<GrantedAuthority> authorityList = getUserAuthority(username);
//        Users users = getUsersInfoByUserName(username);
//        if (username == null) {
//            throw new UsernameNotFoundException("用户不存在");
//        }
//        /**
//         *  User(String username, String password, boolean enabled,
//         * 			boolean accountNonExpired, boolean credentialsNonExpired,
//         * 			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
//         *
//         * username 用户的账号
//         * password 用户的密码
//         * accountNonExpired 账户是否过期
//         * credentialsNonExpired 凭证是否过期
//         * accountNonLocked  账户是否锁定
//         * authorities 权限集合
//         */
//        return new org.springframework.security.core.userdetails.User(users.getUsername(),
//                bCryptPasswordEncoder.encode(users.getPassword()), authorityList);
//    }
//
//    /**
//     * 连接数据库 实现 读取权限集合
//     *
//     * @return 授予的权限
//     */
//    public List<GrantedAuthority> getUserAuthority(String username) {
//        // 创建权限集合
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        // 读取用户的权限集合
//        List<Authorities> userAuthority = authoritiesService.getUserAuthorities(username);
//        for (Authorities a : userAuthority) {
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(a.getAuthority());
//            authorityList.add(grantedAuthority);
//        }
//        return authorityList;
//    }
//
//    /**
//     * 根据用户名查询用户信息
//     *
//     * @param username 用户名
//     * @return 用户信息
//     */
//    @Override
//    public Users getUsersInfoByUserName(String username) {
//        return usersMapper.getUsersInfoByUserName(username);
//    }
//}
