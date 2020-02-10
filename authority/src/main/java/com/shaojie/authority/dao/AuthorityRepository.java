package com.shaojie.authority.dao;

import com.shaojie.authority.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author： ShaoJie
 * @data： 2020年01月06日 21:10
 * @Description： 权限 数据访问层
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
