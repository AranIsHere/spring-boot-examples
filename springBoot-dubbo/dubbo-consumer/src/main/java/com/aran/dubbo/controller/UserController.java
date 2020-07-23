package com.aran.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aran.service.entity.User;
import com.aran.service.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Aran
 * @Date 2020/7/23 8:01 下午
 */
@RestController
public class UserController {
    @Reference(version = "1.0.0")
    private UserService userService;

    @PostMapping("/getUser")
    public String getUser(@RequestBody User user){
        System.out.println(user);
       return  userService.printUser(user);
    }
}
