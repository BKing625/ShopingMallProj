package com.cafe24.mall.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("")
    public String mainPage(){
        return "main/index";
    }

    @GetMapping("/test")
    public String testPage2(){
        return "main/test";
    }
}
