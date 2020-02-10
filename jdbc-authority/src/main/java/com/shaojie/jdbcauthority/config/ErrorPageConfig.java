package com.shaojie.jdbcauthority.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author ShaoJie
 * @Date 2019/10/25
 */
@Configuration
public class ErrorPageConfig {

    // 使用 WebServerFactoryCustomizer 接口替换 EmbeddedServletContainerCustomizer 组件完成对嵌入式Servlet容器的配置
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN,"/403"));
            }
        };
    }

}
