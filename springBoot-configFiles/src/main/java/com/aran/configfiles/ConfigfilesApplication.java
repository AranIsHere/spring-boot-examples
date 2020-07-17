package com.aran.configfiles;

import com.aran.configfiles.yml.YamlGet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.sql.DataSourceDefinition;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ConfigfilesApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConfigfilesApplication.class, args);
    }

}
