package com.shaojie.dubbo.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author： ShaoJie
 * @data： 2019年12月07日 23:13
 * @Description： 不依赖 springboot 的 dubbo 架构的服务提供者
 */
public class DemoApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
        context.start();
        System.in.read(); // 按任意键退出
    }
}
