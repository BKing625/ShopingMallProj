package com.cafe24.mall.controller;

import com.cafe24.mall.vo.ProductVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/")
    public String viewProductList(@ModelAttribute List categoryList,
                                  @ModelAttribute String searchWord){
        // TODO : implementation
        return null;
    }

    @GetMapping("/new")
    public String registerProductForm(){
        // TODO : implementation, add permission
        return null;
    }

    @PostMapping("/")
    public String registerProduct(@ModelAttribute ProductVo pVo){
        // TODO : implementation, add permission
        return null;
    }

    @GetMapping("/{productNo}")
    public String viewProductDetail(@PathVariable(value="productNo") Long id){
        // TODO : implementation
        return null;
    }

    @GetMapping("/{productNo}/modify")
    public String modifyProductForm(@PathVariable(value="productNo") Long id){
        // TODO : implementation, add permission
        return null;
    }

    @PutMapping("/{productNo}")
    public String modifyProduct(@ModelAttribute ProductVo pVo){
        // TODO : implementation, permission check
        return null;
    }

    @DeleteMapping("/{productNo}")
    public String deleteProduct(@PathVariable(value="productNo") Long id){
        // TODO : implementation, add permission
        return null;
    }
}
