package com.pinxixi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.pinxixi.dao")
@SpringBootApplication
public class PinxixiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinxixiServerApplication.class, args);
    }

}
