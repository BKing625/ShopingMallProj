package com.cafe24.mall.frontend.controller;

import com.cafe24.mall.frontend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public String mainPageGetter(){


        return "redirect:/1";
    }

    @GetMapping("/{productPage:[\\d]+}")
    public String mainPage(@PathVariable Integer productPage, Model model){
        model.addAttribute("productList", productService.getList(productPage));
        return "main/index";
    }

    @GetMapping("/test")
    public String testPage2(){
        return "main/test";
    }

}
