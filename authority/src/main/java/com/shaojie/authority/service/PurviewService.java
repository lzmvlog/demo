package com.shaojie.authority.service;

import com.shaojie.authority.model.Purview;

import java.util.List;

/**
 * @author： ShaoJie
 * @data： 2020年02月10日 15:13
 * @Description：
 */
public interface PurviewService {

    /**
     * 查询权限范围
     *
     * @return list 返回权限集合
     */
    List<Purview> selectPurview();

}
