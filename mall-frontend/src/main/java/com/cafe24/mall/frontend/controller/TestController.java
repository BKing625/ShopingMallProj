package com.cafe24.mall.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("")
    public String testPage(){
        return "test";
    }

    @GetMapping("/1")
    public String testPage2(){
        return "test2";
    }
}
