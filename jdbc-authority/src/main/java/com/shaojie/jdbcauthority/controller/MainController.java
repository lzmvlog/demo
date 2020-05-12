package com.shaojie.jdbcauthority.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ShaoJie
 * @Date 2019/10/25
 */
@Slf4j
@Controller
public class MainController {

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("403")
    public String error() {
        return "403";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

}