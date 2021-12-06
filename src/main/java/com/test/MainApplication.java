package com.test;

import com.test.model.User;
import com.test.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
//        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
//        UserService userService =  context.getBean(UserService.class);


//        User user = new User("Aram", "gmail", "psw");
////        userService.update(1, "sadsada");
//        User user1 = userService.getByEmail("gmail");
//        System.out.println(user1);
//        System.out.println(user1);
//        System.out.println(userService.getAll());

    }
}