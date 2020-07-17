package com.aran.aop.controller;

import com.aran.aop.annotation.WebLogger;
import com.aran.aop.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Aran
 * @Date 2020/7/14 10:25 下午
 */
@Slf4j
@RestController
public class UserController {

    @PostMapping("/user")
    @WebLogger(description = "请求了用户接口")
    public User getUser(@RequestBody User user){
        log.info("user ...");
        return user;
    }
}
