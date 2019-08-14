package com.cafe24.mall.frontend.controller;

import com.cafe24.mall.frontend.dto.BucketAddDto;
import com.cafe24.mall.frontend.dto.ProductSimpleViewDto;
import com.cafe24.mall.frontend.service.BucketService;
import com.cafe24.mall.frontend.vo.BucketVo;
import com.cafe24.mall.frontend.vo.UserVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

@Controller
@RequestMapping("/bucket")
public class BucketController {

    @Autowired
    BucketService bucketService;
    @PostMapping("")
    public String addProduct(@ModelAttribute BucketVo bucVo){

        if(bucketService.addItem(bucVo))
            return "redirect:/bucket";
        return "redirect:/";
    }

    @GetMapping("")
    public String view(HttpSession httpSession,  Model model){
        UserVo userVo = (UserVo)httpSession.getAttribute("authUserInfo");
        if(userVo == null) return "redirect:/1";
        List<ProductSimpleViewDto> bucList = bucketService.getList(userVo.getUserNumber());
        model.addAttribute("bucketList", bucList);
        return "bucket/bucket";
    }

    @GetMapping("/delete/{bucNum:[\\d]+}")
    public String delete(HttpSession httpSession, @PathVariable Long bucNum){
        System.out.println("-----------");
        UserVo userVo = (UserVo)httpSession.getAttribute("authUserInfo");
        if(userVo == null) return "redirect:/1";
        Boolean res = bucketService.delete(userVo.getUserNumber(),bucNum);
        if(res)
        return "redirect:/bucket";
        else
            return "redirect:/";
    }
}
