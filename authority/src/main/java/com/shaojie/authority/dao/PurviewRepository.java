package com.shaojie.authority.dao;

import com.shaojie.authority.model.Purview;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author： ShaoJie
 * @data： 2020年02月10日 15:13
 * @Description： 权限范围 数据访问层
 */
public interface PurviewRepository extends JpaRepository<Purview, Integer> {
}
