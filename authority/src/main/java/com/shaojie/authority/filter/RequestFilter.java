package com.shaojie.authority.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author： ShaoJie
 * @data： 2020年02月24日 15:59
 * @Description： 请求拦截器
 */
//@Configuration
@Slf4j
public class RequestFilter /*extends WebAuthenticationDetails*/ implements /*HandlerInterceptor,*/ Filter {

    /**
     * 校验密码
     */
    private boolean passwordIsRight;

    public boolean isPasswordIsRight() {
        return this.passwordIsRight;
    }

    /**
     * Records the remote address and will also set the session Id if a session already
     * exists (it won't create one). 保存会话
     *
     * @param request that the authentication request was received from
     */
//    public RequestFilter(HttpServletRequest request) {
//        super(request);
//        createToken(request);
//    }

    /**
     * 利用 jwt 创建 token
     *
     * @param request 请求
     */
    public void createToken(HttpServletRequest request) {

    }

//    /**
//     * 方法调用之前
//     *
//     * @param request
//     * @param response
//     * @param handler
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info(" 请求之前执行验证 ：{}");
//        return true;
//    }

//    /**
//     * 方法执行中
//     *
//     * @param request
//     * @param response
//     * @param handler
//     * @param modelAndView
//     * @throws Exception
//     */
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }

//    /**
//     * 方法执行后
//     *
//     * @param request
//     * @param response
//     * @param handler
//     * @param ex
//     * @throws Exception
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info(" 请求之前执行验证 ：{}");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
