package com.shaojie.springdata;

import com.shaojie.springdata.dao.UserRepository;
import com.shaojie.springdata.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author 少杰
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
        Optional<User> user = userRepository.findById(1);
        System.out.println(user.toString());
    }

    @Test
    public void save(){
        User u = new User();
        u.setEmail("zhang1591313226@163.con");
        User save = userRepository.save(u);
        // 判断创建的对象是否存在
        if (save != null){
            System.out.println("插入成功");
        }
    }

}
