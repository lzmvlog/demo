package com.shaojie.authority.service.impl;

import com.shaojie.authority.dao.AuthorityRepository;
import com.shaojie.authority.model.Authority;
import com.shaojie.authority.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author： ShaoJie
 * @data： 2020年01月06日 21:14
 * @Description： 权限的业务逻辑层
 */
@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

    /**
     * 权限数据访问层
     */
    @Autowired
    private AuthorityRepository authorityRepository;

    /**
     * 获取用户的权限
     *
     * @param memberId 用户的 id
     * @return 权限的集合
     */
    @Override
    public List<Authority> getUserAuthority(Integer memberId) {
        Example<Authority> example = Example.of(new Authority()
                .setMemberId(memberId));
        return authorityRepository.findAll(example);
    }
}
