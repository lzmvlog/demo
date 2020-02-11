package com.shaojie.authority.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author ShaoJie
 * @Date 2019/10/25
 */
@Slf4j
@Controller
public class MainController {

    /*@Autowired
    private Producer producer;*/

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

    /**
     * 生成图片
     *
     * @param request
     * @param response
     */
    @GetMapping("captcha.jpg")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        // 设置内容类型
        response.setContentType("image/jpeg");
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        // 将验正码文本设置到 session 中
        request.getSession().setAttribute("captcha", lineCaptcha.getCode());
        BufferedImage image = lineCaptcha.getImage();
        try {
            @Cleanup ServletOutputStream outputStream = response.getOutputStream();
            // 将图片验证码数据写到响应的输出流
            ImageIO.write(image, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* 已抛弃 GitHub 提示存在安全问题

        // 设置内容类型
        response.setContentType("image/jpeg");
        // 创建验正码文本
        String capText = producer.createText();
        // 将验正码文本设置到 session 中
        request.getSession().setAttribute("captcha", capText);
        // 创建验证码图片
        BufferedImage bufferedImage = producer.createImage(capText);
        // 获取响应的输出流
        try {
            @Cleanup ServletOutputStream outputStream = response.getOutputStream();
            // 将图片验证码数据写到响应的输出流
            ImageIO.write(bufferedImage, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        */

    }

}