package com.cafe24.mall.service;

import com.cafe24.dto.JsonResult;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public JsonResult existId(String emailAddress){
        // TODO : implementation
        return JsonResult.success(true);
    }
}
