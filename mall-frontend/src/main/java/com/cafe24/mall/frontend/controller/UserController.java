package com.cafe24.mall.frontend.controller;

import com.cafe24.mall.frontend.service.UserService;
import com.cafe24.mall.frontend.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/join")
    public String userJoinForm(){

        return "user/join";
    }

    @PostMapping("/join")
    public String userJoin(@ModelAttribute UserVo userVo, Model model){
        System.out.println(userVo);
        Boolean res = userService.join(userVo);

        model.addAttribute("result", res);
        model.addAttribute("message", res?"가입을 환영합니다":"가입 실패하였어요 ㅠㅠ");
        return "user/joinResult";
    }
}
