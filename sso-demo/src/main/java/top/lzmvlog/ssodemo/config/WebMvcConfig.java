package top.lzmvlog.ssodemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.lzmvlog.ssodemo.filter.CookieHandlerInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	
	@Autowired
	private CookieHandlerInterceptor cookieHandlerInterceptor;
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.cookieHandlerInterceptor).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
	
}