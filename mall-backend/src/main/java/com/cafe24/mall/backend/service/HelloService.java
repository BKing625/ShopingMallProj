package com.cafe24.mall.backend.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class HelloService {

    public String getHelloMessage(){
        return "Hello World";
    }
}
