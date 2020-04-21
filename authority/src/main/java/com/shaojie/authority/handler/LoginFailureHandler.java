package com.shaojie.authority.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ShaoJie
 * @Date 2020年04月18 20:17
 * @Description: 登录失败的处理器
 * SimpleUrlAuthenticationFailureHandler:
 *      AuthenticationFailureHandler 当调用 onAuthenticationFailure 方法时，它将重定向到
 * {@link #setDefaultFailureUrl defaultFailureUrl}属性的值。如果尚未设置该属性，它将*向客户端发送401响应，
 * 并带有 AuthenticationException 的错误消息，该错误消息会导致失败。
 * 如果设置了{@code useForward}属性，则将对目标进行{@code RequestDispatcher.forward}调用，而不是重定向。
 */
@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    /**
     * 执行重定向或转发到{@code defaultFailureUrl}（如果已设置），否则*返回401错误代码。
     *    如果重定向或转发，将调用{@code saveException}来缓存*异常，以供在目标视图中使用。
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("登录失败");
    }
}
