package com.aran.test.controller;

import com.aran.test.service.FakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Aran
 * @Date 2020/7/21 10:26 下午
 */
@RestController
public class TestController {

    @Autowired
    FakeService fakeService;

    @GetMapping("/test")
    @ResponseBody
    public void myTest(){
        for (int i = 0; i < 10; i++) {
            fakeService.test(i);
        }
    }
}
