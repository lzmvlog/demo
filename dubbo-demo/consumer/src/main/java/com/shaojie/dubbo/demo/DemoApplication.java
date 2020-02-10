package com.shaojie.dubbo.demo;

import com.shaojie.dubbo.demo.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author： ShaoJie
 * @data： 2019年12月07日 23:13
 * @Description： 不依赖 springboot 的 dubbo 架构的服务消费者
 */
public class DemoApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        OrderService bean = context.getBean(OrderService.class);
        bean.initOrder(1);
    }
}
