package com.cafe24.mall.controller;

import java.util.List;

import com.cafe24.mall.service.UserService;
import com.cafe24.mall.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

// TODO : add mappings, implement methods
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewUserList(){
        // TODO : implementation, admin permission
        return null;
    }

    @GetMapping("/new")
    public String signUpForm(@ModelAttribute UserVo userVo) {
        // TODO : implementation
        return "user/joinForm";
    }

    @GetMapping("/login")
    public String signInForm(){
        // TODO : implementation
        return null;
    }

    @PostMapping("/login")
    public String signIn(){
        // TODO : implementation
        return null;
    }

    @PostMapping("/")
    public String addUser(){
        // TODO : implementation
        return null;
    }

    @GetMapping("/{idNo}/modify")
    public String modifyUserForm(@PathVariable(value="idNo") Long id){
        // TODO : implementation, permission check
        return null;
    }

    @PutMapping("/{idNo}")
    public String modifyUser(@PathVariable(value="idNo") Long id){
        // TODO : implementation, permission check
        return null;
    }

    @DeleteMapping("/{idNo}")
    public String deleteUser(@PathVariable(value="idNo") Long id){
        // TODO : implementation, permission check
        return null;
    }


}
