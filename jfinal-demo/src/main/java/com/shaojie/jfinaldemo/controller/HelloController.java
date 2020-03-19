package com.shaojie.jfinaldemo.controller;

import com.jfinal.core.Controller;

/**
 * @author： ShaoJie
 * @data： 2020年03月05日 12:33
 * @Description： 控制器
 */
public class HelloController extends Controller {

    public void index() {
        renderText("Hello JFinal World.");
    }

    public void hello() {
        renderText("say Hello JFinal World.");
    }

    public void hi() {
        renderText("sayHI Hello JFinal World.");
    }

}
