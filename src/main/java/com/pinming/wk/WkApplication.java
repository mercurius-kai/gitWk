package com.pinming.wk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.pinming.wk.mapper")
@EnableScheduling
@SpringBootApplication
public class WkApplication {

    public static void main(String[] args) {
        SpringApplication.run(WkApplication.class, args);
    }

}
