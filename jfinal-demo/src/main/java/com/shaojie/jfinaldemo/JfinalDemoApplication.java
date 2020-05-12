package com.shaojie.jfinaldemo;

import com.jfinal.server.undertow.UndertowServer;
import com.shaojie.jfinaldemo.config.JfinalConfig;

//@SpringBootApplication
public class JfinalDemoApplication {

    /**
     * 启动入口，运行此 main 方法可以启动项目，此 main 方法可以放置在任意的 Class 类定义中，不一定要放于此
     * <p>
     * 使用本方法启动过第一次以后，会在开发工具的 debug、run configuration 中自动生成
     * 一条启动配置项，可对该自动生成的配置再继续添加更多的配置项，例如 Program arguments
     * 可配置为：src/main/webapp 80 / 5
     */
    public static void main(String[] args) {
//        JFinal.start();
//        JFinal.start("src/main/resources/templates",8080,"/");
        UndertowServer.start(JfinalConfig.class, 8080, true);
//        SpringApplication.run(JfinalDemoApplication.class, args);
    }

}
