package com.aran.service.entity;
import	java.io.Serializable;

import lombok.Data;

/**
 * @Author Aran
 * @Date 2020/7/23 7:53 下午
 */
@Data
public class User implements Serializable{
    private String userName;
    private String age;

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
