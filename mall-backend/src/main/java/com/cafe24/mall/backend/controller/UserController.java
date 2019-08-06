package com.cafe24.mall.backend.controller;

import com.cafe24.dto.JsonResult;
import com.cafe24.mall.backend.vo.UserVo;
import com.cafe24.mall.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

// TODO : add mappings, implement methods
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService  userService;
    @Autowired
    public  UserController(UserService  userService){
        this.userService = userService;
    }


    @GetMapping("/list/{userPage:[\\d]+}")
    public JsonResult getUserList(@PathVariable Integer userPage){
        // TODO : admin permission
        return JsonResult.success(userService.getList(userPage));
    }

    // move to front
    @Deprecated
    @GetMapping("/new")
    public String signUpForm() {
        // TODO : implementation
        return "user/joinForm";
    }


    // move to front
    @Deprecated
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


    // move to security
    @Deprecated
    @GetMapping("/logout")
    public String logout(){
        // TODO : move to security & implementation
        return null;
    }



    @PostMapping("")
    public ResponseEntity<JsonResult> joinUser(@RequestBody @Valid UserVo userVo,
                                               BindingResult result){
        if(result.hasErrors()) {
            List<ObjectError> errors=result.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.toString());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(JsonResult.fail(error.getDefaultMessage()));
            }
        }

        ResponseEntity<JsonResult> res;

        if(userService.add(userVo))
            res = ResponseEntity.status(HttpStatus.CREATED).body(JsonResult.success(null));
        else
            res = ResponseEntity.status(500).body(JsonResult.fail("add fail"));
        return res;
    }

    // move to front
    @Deprecated
    @GetMapping("/{idNo}/modify")
    public String modifyUserForm(@PathVariable(value="idNo") Long id){
        // TODO : implementation, permission check
        return null;
    }

    @PutMapping("")
    public ResponseEntity modifyUser(@RequestBody @Valid UserVo userVo,
                             BindingResult result){
        // TODO : permission check

        if(result.hasErrors()) {
            List<ObjectError> errors=result.getAllErrors();
            for (ObjectError error : errors) {
                if ("pwd must not be empty".equals(error.getDefaultMessage())) {
                    System.out.println(error.toString());
                    continue;
                }
                System.out.println("-::"+ error.getDefaultMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(JsonResult.fail(error.getDefaultMessage()));
            }
        }

        ResponseEntity res;
        if(userService.modify(userVo))
            res = ResponseEntity.status(200).body(JsonResult.success(null));
        else
            res = ResponseEntity.status(500).body(JsonResult.fail("add fail"));
        return res;
    }

    @DeleteMapping("/{idNo}")
    public ResponseEntity deleteUser(@PathVariable(value="idNo") Long id){
        // TODO : permission check

        UserVo delUserVo = new UserVo();
        delUserVo.setUserNumber(id);
        ResponseEntity res = null;
        if(userService.delete(delUserVo))
            res = ResponseEntity.status(200).body(null);
        else
            res = ResponseEntity.status(500).body(null);
        return res;
    }

    // API
    @ResponseBody
    @GetMapping("/idcheck")
    public ResponseEntity<JsonResult> idCheck(@RequestBody String idStr){

        UserVo userVo = new UserVo();
        userVo.setUserId(idStr);
        Validator validator =
                Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<UserVo>> violations = validator.validateProperty(userVo,"userId");
        if (!violations.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        JsonResult res;
        if(userService.existId(idStr))
            res = JsonResult.fail(null);
        else
            res = JsonResult.success(null);
        return ResponseEntity.ok().body(res);
    }
}
