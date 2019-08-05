package com.cafe24.mall.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class MallBackEnd {

    public static void main(String[] args) {
        SpringApplication.run(MallBackEnd.class, args);
    }

}
