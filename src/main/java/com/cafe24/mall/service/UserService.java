package com.cafe24.mall.service;

import com.cafe24.dto.JsonResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class UserService {

    @ResponseBody
    @GetMapping("/user/api/checkemail")
    public JsonResult existEmail(String emailAddress){

        return JsonResult.success(true);
    }
}
