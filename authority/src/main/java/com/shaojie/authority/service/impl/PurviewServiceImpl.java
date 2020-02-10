package com.shaojie.authority.service.impl;

import com.shaojie.authority.dao.PurviewRepository;
import com.shaojie.authority.model.Purview;
import com.shaojie.authority.service.PurviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author： ShaoJie
 * @data： 2020年02月10日 15:14
 * @Description：
 */
@Service
@Transactional
public class PurviewServiceImpl implements PurviewService {

    @Autowired
    public PurviewRepository purviewRepository;

    /**
     * 查询权限范围
     *
     * @return list 返回权限集合
     */
    @Override
    public List<Purview> selectPurview() {
        return purviewRepository.findAll();
    }
}
