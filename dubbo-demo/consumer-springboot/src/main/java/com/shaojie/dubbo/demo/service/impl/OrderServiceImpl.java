package com.shaojie.dubbo.demo.service.impl;

import com.shaojie.dubbo.demo.model.User;
import com.shaojie.dubbo.demo.service.OrderService;
import com.shaojie.dubbo.demo.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author： ShaoJie
 * @data： 2019年12月09日 21:07
 * @Description：
 */
@Service
@Component
public class OrderServiceImpl implements OrderService {

//    @Autowired
//  关闭某个服务的启动时检查 (没有提供者时报错)： 配置了  onsumer 的 check 就可以做全局的控制
    @Reference(check = false)
//    dubbo 直连 跳过 注册中心 loadbalance 负载均衡
//    @Reference(url = "127.0.0.1:20880",loadbalance = "")
    private UserService userService;

    public List<User> initOrder(Integer id) {
        System.out.println("用户的id:" + id);
        // 查询用户的信息
        return userService.getUserList(id);
    }

}
