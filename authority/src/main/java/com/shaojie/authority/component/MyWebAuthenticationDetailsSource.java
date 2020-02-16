package com.shaojie.authority.component;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author： ShaoJie
 * @data： 2020年02月10日 21:56
 * @Description：
 */
@Component
public class MyWebAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {

    /**
     * 当类希望创建新的身份验证详细信息实例时由类调用。
     *
     * @param context 请求对象，可以由身份验证详细信息使用
     * @return
     */
    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new MyWebAuthenticationDetails(context);
    }
}
