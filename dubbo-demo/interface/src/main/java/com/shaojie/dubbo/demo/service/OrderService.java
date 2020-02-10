package com.shaojie.dubbo.demo.service;

import com.shaojie.dubbo.demo.model.User;

import java.util.List;

/**
 * @author： ShaoJie
 * @data： 2019年12月07日 22:11
 * @Description：
 */
public interface OrderService {

    /**
     * 初始化订单
     *
     * @param id 用户 id
     * @return
     */
    List<User> initOrder(Integer id);

}
