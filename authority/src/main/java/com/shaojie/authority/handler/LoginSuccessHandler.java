package com.shaojie.authority.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ShaoJie
 * @Date 2020年04月18 20:15
 * @Description: 登录成功显示的处理器
 * <p>
 * SimpleUrlAuthenticationSuccessHandler:
 * AuthenticationSuccessHandler 可以使用默认URL进行配置，*成功认证后应将*用户发送到该URL。
 */
@Component
@Slf4j
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    /**
     * @param request
     * @param response
     * @param chain
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        // 签发 token
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        log.info("principal:{},{}", principal.getUsername());
//        response.getWriter().write("token=" + token);
    }

    /**
     * 签发 token
     *
     * @return
     */
    public String issue() {

        return null;
    }
}
