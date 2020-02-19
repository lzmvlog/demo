package com.shaojie.authority.component;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * @author： ShaoJie
 * @data： 2020年02月10日 21:54
 * @Description：
 */
@Slf4j
public class MyWebAuthenticationDetails extends WebAuthenticationDetails {

    /**
     * 验证码是否正确
     */
    private boolean imageCodeIsRight;

    public boolean getImageCodeIsRight() {
        return this.imageCodeIsRight;
    }

    /**
     * Records the remote address and will also set the session Id if a session already
     * exists (it won't create one). 保存会话
     * 补充用户提交的验证码和 session 保存的验证码
     *
     * @param request that the authentication request was received from
     */
    public MyWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        // 后去验证表单的值 --> 图形验证码
        String captcha = request.getParameter("captcha");
        log.info("表单的验证码captcha： {}", captcha);
        // 取出 访问时 已经添加在 session 中的验证码
        String sessionCaptcha = (String) request.getSession().getAttribute("captcha");
        log.info("session的验证码： {}", sessionCaptcha);
        // 判断两次的值是否值一样的
        if (!StrUtil.isEmpty(sessionCaptcha)) {
            // 清楚当前的验证码 无论是否成功或是失败 客户端登录失败应刷新当前的验证码
            request.getSession().removeAttribute("captcha");
            // 当验证码正确 修改当前的状态
            if (!StrUtil.isEmpty(captcha) && captcha.equals(sessionCaptcha)) {
                this.imageCodeIsRight = true;
            }
        }
    }
}
