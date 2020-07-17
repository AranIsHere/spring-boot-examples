package com.aran.configfiles.yml;

import com.aran.configfiles.Entity.User;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author Aran
 * @Date 2020/7/17 7:07 下午
 */
@Data
@Component
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = {"classpath:application.yml"})
public class YamlGet {
    private String str;
    private String singleQouteStr;
    private String doubleQouteStr;
    private boolean aBoolean;
    private int aNum;
    private double aDouble;
    private List<String> aList;
    private String[] aArray;
    private String[] aArray2;
    private Map<String,String> aMap;
    private List<User> aObjectList;




}
