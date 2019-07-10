package com.cafe24.mall.controller;

import java.util.List;

import com.cafe24.mall.service.UserService;
import com.cafe24.mall.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    // TODO : add mappings, implement methods

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join(@ModelAttribute UserVo userVo) {

        return "user/join";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(@ModelAttribute @Valid UserVo userVo
            , BindingResult result
            , Model model) {
        //System.out.println(userVo);

        if(result.hasErrors()) {
            List<ObjectError> errors=result.getAllErrors();
            for(ObjectError error : errors)
                System.out.println(error.toString());
            model.addAllAttributes(result.getModel());
            return "user/join";
        }

        //userService.join(userVo);
        return "redirect:/user/joinsuccess";
    }
}
