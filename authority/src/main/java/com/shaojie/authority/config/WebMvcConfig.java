package com.shaojie.authority.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author： ShaoJie
 * @data： 2020年03月02日 17:01
 * @Description： 配置拦截的资源或者是请求的路径
 */
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    }
}
