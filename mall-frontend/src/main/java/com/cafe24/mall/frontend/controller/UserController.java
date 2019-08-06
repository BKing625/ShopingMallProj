package com.cafe24.mall.frontend.controller;

import com.cafe24.mall.frontend.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/join")
    public String userJoinForm(){

        return "user/join";
    }

    @PostMapping("/join")
    public String userJoin(@ModelAttribute UserVo userVo, Model model){
        System.out.println(userVo);
        Boolean res = !userVo.getUserName().equals("f");
        System.out.println(res);
        model.addAttribute("result", res);
        model.addAttribute("message", "가입을 환영합니다");
        return "user/joinResult";
    }
}
