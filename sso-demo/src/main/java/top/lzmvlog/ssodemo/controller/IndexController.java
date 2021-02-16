package top.lzmvlog.ssodemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import top.lzmvlog.ssodemo.dao.UserRepository;
import top.lzmvlog.ssodemo.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2021年02月13日 16:58
 * @Description:
 */
@Controller
public class IndexController {

    @Autowired
    UserRepository userRepository;

    /**
     * 将要跳转的路径
     */
    public String url;

    /**
     * 登录界面
     *
     * @return
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 登录界面
     *
     * @return
     */
    @GetMapping("/")
    public String index1() {
        return "index";
    }

    /**
     * 登录请求接口
     *
     * @param username 账号
     * @param password 密码
     * @param response
     * @return
     */
    @PostMapping("login")
    public String login(String username, String password, HttpServletResponse response) {
        // 用户登录
        boolean exists = userRepository.exists(Example.of(new User()
                .setUsername(username)
                .setPassword(password)));
        if (exists) {
            Cookie cookie = new Cookie("username", username);
            response.addCookie(cookie);
            if (StringUtils.isEmpty(url)) {
                return "demo1";
            }
            return url;
        }
        return "index";
    }

    /**
     * 跳转到 demo2
     *
     * @return
     */
    @GetMapping("demo2")
    public String demo2() {
        return "demo2";
    }

    /**
     * 跳转到  demo1
     *
     * @return
     */
    @GetMapping("demo1")
    public String demo1() {
        return "demo1";
    }

}
