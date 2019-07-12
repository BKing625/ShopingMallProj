package com.cafe24.mall.controller;

import com.cafe24.dto.JsonResult;
import com.cafe24.mall.service.UserService;
import com.cafe24.mall.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// TODO : add mappings, implement methods
@Controller
@RequestMapping("/users")
public class UserController {

    private  final  UserService  userService;

    @Autowired
    public  UserController(UserService  userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String viewUserList(){
        // TODO : implementation, admin permission
        return null;
    }

    @GetMapping("/new")
    public String signUpForm() {
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
        // TODO : move to security & implementation
        return null;
    }

    @GetMapping("/logout")
    public String logout(){
        // TODO : move to security & implementation
        return null;
    }

    @PostMapping("/")
    public String joinUser(@ModelAttribute UserVo userVo){
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

    // API
    @ResponseBody
    @GetMapping("/api/idcheck")
    public JsonResult idCheck(@ModelAttribute String idStr){
        return userService.existId(idStr);
    }
}
