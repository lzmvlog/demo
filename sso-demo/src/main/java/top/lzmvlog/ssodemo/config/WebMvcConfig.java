package top.lzmvlog.ssodemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.lzmvlog.ssodemo.handler.SessionHandlerInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * Session 拦截处理器
     */
    @Autowired
    private SessionHandlerInterceptor sessionHandlerInterceptor;

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.sessionHandlerInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}