package top.lzmvlog.ssodemo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.lzmvlog.ssodemo.controller.IndexController;
import top.lzmvlog.ssodemo.dao.UserRepository;
import top.lzmvlog.ssodemo.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2021年02月13日 17:58
 * @Description:
 */
@Component
public class SessionHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IndexController indexController;

    /**
     * 执行方法之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取当前请求得路径 如果不是正常得登录界面请求 登录成功之后需要跳转到原来请求得界面上
        String servletPath = request.getServletPath();
        // 对不需要拦截得路径进行放行
        if ("/index".equals(servletPath) || "/".equals(servletPath) || "/login".equals(servletPath)) {
            return true;
        }
        if (!"/index".equals(servletPath) || !"/".equals(servletPath)) {
            indexController.url = servletPath;
        }
        String username = (String) request.getSession().getAttribute("username");
        boolean exists = false;
        if (!StringUtils.isEmpty(username)) {
            exists = userRepository.exists(Example.of(new User()
                    .setUsername(username)));
        }
        if (exists) {
            return true;
        } else {
            response.sendRedirect("/index");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 方法执行完成之后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
