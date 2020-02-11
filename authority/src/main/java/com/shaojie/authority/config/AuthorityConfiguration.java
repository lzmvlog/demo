package com.shaojie.authority.config;

import org.springframework.stereotype.Component;

/**
 * @author： ShaoJie
 * @data： 2020年02月08日 20:02
 * @Description： 配置图形验证码 已抛弃 GitHub 提示存在安全问题
 */
@Component
public class AuthorityConfiguration {

    /**
     * 配置 kaptcha 实例
     *
     * @return 图形创建者
     */
    /*@Bean
    public Producer captcha() {
        // 配置 图形眼正码的基本参数
        Properties properties = new Properties();
        // 图片的宽度
        properties.setProperty("kaptcha.image.width", "150");
        // 图片的长度
        properties.setProperty("kaptcha.image.height", "50");
        // 字符集
        properties.setProperty("kaptcha.textproducer.char.String", "0123456789");
        // 字符长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        Config config = new Config(properties);
        // 使用默认的图形眼正码实现 可自定义实现
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }*/

}
