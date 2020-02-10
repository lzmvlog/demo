package com.shaojie.jdbcauthority.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author： ShaoJie
 * @data： 2020年01月09日 22:50
 * @Description： 用户
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Users implements UserDetails {
    /**
     * 用户名
     */
    private String username;

    /**
     * 账号密码
     */
    private String password;

    /**
     * 账号是否启用
     */
    private Boolean enabled;

    public Users() {

    }

    /**
     * 用户的权限集合
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 账号是否异常
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * 账户是否锁定
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    /**
     * 凭证是否过期
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * 是否启用
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return false;
    }
}