package com.aran.test.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Aran
 * @Date 2020/7/21 10:23 下午
 */
@Service
public class FakeService {

    @Async
    public void test(int i){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try{
            Thread.sleep(10000);
            System.out.println("多线程异步执行：" + i +
                    Thread.currentThread().getName() + " "
                    +format.format(new Date()));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
