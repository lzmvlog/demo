package top.lzmvlog.ssodemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import top.lzmvlog.ssodemo.dao.UserRepository;
import top.lzmvlog.ssodemo.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/")
    public String index1(HttpServletRequest request) {
        return "index";
    }

    @GetMapping("login")
    public String login(String username, String password, HttpServletRequest request) {
        // 用户登录
        boolean exists = userRepository.exists(Example.of(new User()
                .setUsername(username)
                .setPassword(password)));
        if (exists) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            // 指定客户机请求之间的时间，以秒为单位，此时间间隔表示servlet容器使该会话无效。时间为零或负数表示会话永不超时。
            session.setMaxInactiveInterval(7200);
            if (StringUtils.isEmpty(url)) {
                return "demo1";
            }
            return url;
        }
        return "index";
    }

    @GetMapping("demo2")
    public String demo2() {
//        // 用户登录
//        boolean exists = userRepository.exists(Example.of(new User()
//                .setUsername(username)
//                .setPassword(password)));
//        if (exists) {
//            HttpSession session = request.getSession();
//            session.setAttribute("username", username);
//            // 指定客户机请求之间的时间，以秒为单位，此时间间隔表示servlet容器使该会话无效。时间为零或负数表示会话永不超时。
//            session.setMaxInactiveInterval(7200);
//            return "demo2";
//        }
        return "demo2";
    }

    @GetMapping("demo1")
    public String demo1() {
        // 用户登录
//        boolean exists = userRepository.exists(Example.of(new User()
//                .setUsername(username)
//                .setPassword(password)));
//        if (exists) {
//            HttpSession session = request.getSession();
//            session.setAttribute("username", username);
//            // 指定客户机请求之间的时间，以秒为单位，此时间间隔表示servlet容器使该会话无效。时间为零或负数表示会话永不超时。
//            session.setMaxInactiveInterval(7200);
//            return "demo1";
//        }
        return "demo1";
    }

}
