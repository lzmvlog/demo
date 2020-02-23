package com.shaojie.authority.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author ShaoJie
 * @Date 2019年11月25 17:49
 * @Description:
 */
@Data
@Entity
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "user")
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = -6141968021538997884L;

    /**
     * 用户的自增 id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户的账号
     */
    @Column(name = "name")
    private String name;

    /**
     * 用户的密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 账号是否启用
     */
    @Column(name = "enable")
    private Boolean enable;

    public User() {

    }

    /**
     * 获取用户权限
     *
     * @return 用户权限集合
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
