package com.cafe24.mall.frontend.controller;

import com.cafe24.mall.frontend.dto.ProductDto;
import com.cafe24.mall.frontend.service.ProductService;
import com.cafe24.mall.frontend.vo.ProductVo;
import com.cafe24.mall.frontend.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/add")
    public String addProductForm(){

        return "product/addForm";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductDto productBuffer){
        //System.out.println(productBuffer);
        productService.add(productBuffer);
        return "product/addForm";
    }
}
