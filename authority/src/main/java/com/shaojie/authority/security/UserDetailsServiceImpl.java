package com.shaojie.authority.security;

import com.shaojie.authority.model.Authority;
import com.shaojie.authority.model.User;
import com.shaojie.authority.service.UserService;
import com.shaojie.authority.service.impl.AuthorityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaoJie
 * @Date 2019年11月26 19:48
 * @Description:
 */
@Service
@Transactional
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 用户 业务逻辑层
     */
    @Autowired
    private UserService userService;

    /**
     * 权限 业务逻辑层
     */
    @Autowired
    private AuthorityServiceImpl authorityService;

    /**
     * 密码加密
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 加载登录 通过用户名查找用户
     *
     * @param userName 登录的用户名称
     * @return 用户信息
     * @throws UsernameNotFoundException 未找到用户登录名称信息
     */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(@RequestParam String userName) {
        log.info("{ 当前登录的用户账号：  {} }", userName);
        User user = userService.findUserByName(userName);
        // 权限集合 当前用户所具有的权限
        List<GrantedAuthority> authorityList = getUserAuthority(user.getId());
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        /**
         *  User(String username, String password, boolean enabled,
         * 			boolean accountNonExpired, boolean credentialsNonExpired,
         * 			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
         *
         * username 用户的账号
         * password 用户的密码
         * accountNonExpired 账户是否过期
         * credentialsNonExpired 凭证是否过期
         * accountNonLocked  账户是否锁定
         * authorities 权限集合
         */
        return new org.springframework.security.core.userdetails.User(user.getName(),
                bCryptPasswordEncoder.encode(user.getPassword()), authorityList);
    }

    /**
     * 连接数据库 实现 读取权限集合
     *
     * @return 授予的权限
     */
    public List<GrantedAuthority> getUserAuthority(Integer memberId) {
        // 创建权限集合
        List<GrantedAuthority> authorityList = new ArrayList<>();
        // 读取用户的权限集合
        List<Authority> userAuthority = authorityService.getUserAuthority(memberId);
        for (Authority a : userAuthority) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(a.getAuthority());
            authorityList.add(grantedAuthority);
        }
        return authorityList;
    }

}
