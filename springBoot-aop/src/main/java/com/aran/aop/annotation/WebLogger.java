package com.aran.aop.annotation;
import java.lang.annotation.*;

/**
 *
 * ① 什么时候使用该注解
 * ② 注解用于什么地方
 * ③ 注解是否包含在JavaDoc中
 * ④ 注解名
 * ⑤ 定义一个属性，默认为空字符串
 *
 * @Author Aran
 * @Date 2020/7/14 7:40 上午
 */
@Retention(RetentionPolicy.RUNTIME)   //1
@Target({ElementType.METHOD})//2
@Documented//3
public @interface WebLogger { //4
    String description() default ""; //5
}
