package com.shaojie.springdata.controller;

import com.shaojie.springdata.dao.UserRepository;
import com.shaojie.springdata.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 少杰
 */
@Controller
public class TestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/say/{id}")
    public User say(@PathVariable("id") Integer id){
        return userRepository.findById(id).get();
    }

   @GetMapping("/save")
    public User insert(){
        User u = new User();
       u.setEmail("1591313226");
       return userRepository.save(u);
    }

    @PostMapping( value = "/registered")
    public String registered(User user){
        if (userRepository.save(user) != null) {
            return "success";
        }
        return "error";
    }

    @GetMapping("/find/{id}")
    public User find(@PathVariable("id") Integer id){
        return userRepository.queryAllById(id);
    }

}
