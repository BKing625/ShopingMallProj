package com.cafe24.mall.backend.controller;

import com.cafe24.mall.backend.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/")
    public String hello() {
        System.out.println("Hello");
        return helloService.getHelloMessage();
    }
}
