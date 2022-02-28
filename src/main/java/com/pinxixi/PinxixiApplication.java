package com.pinxixi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.pinxixi.dao")
@SpringBootApplication
@EnableCaching
public class PinxixiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinxixiApplication.class, args);
    }

}
