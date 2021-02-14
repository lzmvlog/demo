package top.lzmvlog.ssodemo.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import top.lzmvlog.ssodemo.controller.IndexController;
import top.lzmvlog.ssodemo.dao.UserRepository;
import top.lzmvlog.ssodemo.model.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2021年02月13日 22:50
 * @Description:
 */
//@Component
public class CookieFilter extends OncePerRequestFilter {

    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 获取当前请求得路径 如果不是正常得登录界面请求 登录成功之后需要跳转到原来请求得界面上
        String servletPath = request.getServletPath();
        IndexController indexController = new IndexController();
        // 对不需要拦截得路径进行放行
        if ("/index".equals(servletPath) || "/".equals(servletPath) || "/login".equals(servletPath)) {
            filterChain.doFilter(request, response);
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
            filterChain.doFilter(request, response);

        } else {
            response.sendRedirect("/");
        }
    }
}
