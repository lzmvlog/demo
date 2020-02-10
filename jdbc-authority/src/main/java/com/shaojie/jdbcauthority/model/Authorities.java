package com.shaojie.jdbcauthority.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author： ShaoJie
 * @data： 2020年01月09日 22:02
 * @Description： 权限类
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Authorities {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 角色或者说权限
     */
    private String authority;
}
