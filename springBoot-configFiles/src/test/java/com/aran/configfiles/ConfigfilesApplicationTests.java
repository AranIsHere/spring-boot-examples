package com.aran.configfiles;

import com.aran.configfiles.yml.YamlGet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigfilesApplicationTests {

    @Autowired
    YamlGet yamlGet;
    @Test
    void contextLoads() {
    }

    @Test
    void yamlTest(){
        System.out.println(yamlGet.toString());
    }
}
