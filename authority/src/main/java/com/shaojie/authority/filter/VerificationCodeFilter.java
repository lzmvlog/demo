package com.shaojie.authority.filter;

import cn.hutool.core.util.StrUtil;
import com.shaojie.authority.exception.VerificationCodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author： ShaoJie
 * @data： 2020年02月09日 16:40
 * @Description： 图形验证码过滤器
 * <p>
 * OncePerRequestFilter 可以确保一次请求只会通过一次该过滤器 （Filter 在实际的操作中并不能保证这一点）
 * 这里这个是使用的 springsecurity  配置 实现拦截验证
 */
@Slf4j
public class VerificationCodeFilter extends OncePerRequestFilter {

    /**
     * 与{@code doFilter}的合同相同，但保证在单个请求线程中每个请求仅被调用一次。
     * 有关详细信息，请参见{@link #shouldNotFilterAsyncDispatch（）}。
     * <p>提供HttpServletRequest和HttpServletResponse参数，而不是默认的ServletRequest和ServletResponse参数。
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // 非登录请求不校验当前的值
        if (!"/index".equals(request.getRequestURI())) {
            // 放行
        } else {
            verificationCode(request);
        }
        filterChain.doFilter(request, response);
    }

    /**
     * 验证 登录的验证码
     *
     * @param request
     * @throws VerificationCodeException 图形验证码错误
     */
    public void verificationCode(HttpServletRequest request) throws VerificationCodeException {
        // 后去验证表单的值 --> 图形验证码
        String captcha = request.getParameter("captcha");
        log.info("表单的验证码： {}", captcha);
        // 取出 访问时 已经添加在 session 中的验证码
        String sessionCaptcha = (String) request.getSession().getAttribute("captcha");
        log.info("session的验证码： {}", sessionCaptcha);
        // 判断两次的值是否值一样的
        if (!StrUtil.isEmpty(sessionCaptcha)) {
            // 清楚当前的验证码 无论是否成功或是失败 客户端登录失败应刷新当前的验证码
            request.getSession().removeAttribute("captcha");
        }
        // 表单提交的验证码 session 中的验证码 两者均不能为空 且两者需一致
        if (StrUtil.isEmpty(captcha) || StrUtil.isEmpty(sessionCaptcha) || !captcha.equals(sessionCaptcha)) {
            // 这里有个问题 不管是任何时候都会校验这个图形验证码 需要判断一下请求的路径
            throw new VerificationCodeException();
        }
    }
}
