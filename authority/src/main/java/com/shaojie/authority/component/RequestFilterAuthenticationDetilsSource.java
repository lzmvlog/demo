package com.shaojie.authority.component;

import com.shaojie.authority.filter.RequestFilter;
import org.springframework.security.authentication.AuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * @author： ShaoJie
 * @data： 2020年02月24日 16:50
 * @Description： 暂时没有用处
 */
public class RequestFilterAuthenticationDetilsSource implements AuthenticationDetailsSource<HttpServletRequest, RequestFilter> {

    /**
     * 当类希望创建新的身份验证详细信息实例时由类调用。
     *
     * @param context 请求对象，可以由身份验证详细信息使用
     * @return
     */
    @Override
    public RequestFilter buildDetails(HttpServletRequest context) {
//        return new RequestFilter(context);
        return null;
    }
}
