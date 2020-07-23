package com.aran.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.aran.service.entity.User;
import com.aran.service.service.UserService;

import org.springframework.stereotype.Component;

/**
 * @Author Aran
 * @Date 2020/7/23 7:55 下午
 */
@Service(version="1.0.0")
@Component
public class UserServiceImpl implements UserService {
    @Override
    public String printUser(User user) {
         return user.toString();
    }
}
