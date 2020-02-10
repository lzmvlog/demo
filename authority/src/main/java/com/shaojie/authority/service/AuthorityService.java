package com.shaojie.authority.service;

import com.shaojie.authority.model.Authority;

import java.util.List;

/**
 * @author： ShaoJie
 * @data： 2020年01月06日 21:14
 * @Description： 权限的业务逻辑层
 */
public interface AuthorityService {

    /**
     * 获取用户的权限
     *
     * @param memberId 用户的 id
     * @return 权限的集合
     */
    List<Authority> getUserAuthority(Integer memberId);
}
