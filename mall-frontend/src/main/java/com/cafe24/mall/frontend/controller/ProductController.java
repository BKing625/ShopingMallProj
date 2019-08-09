package com.cafe24.mall.frontend.controller;

import com.cafe24.mall.frontend.dto.ProductDto;
import com.cafe24.mall.frontend.service.ProductService;
import com.cafe24.mall.frontend.vo.OptionVo;
import com.cafe24.mall.frontend.vo.ProductVo;
import com.cafe24.mall.frontend.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @GetMapping("/{productNumber:[\\d]+}")
    public String mainPage(@PathVariable Long productNumber, Model model){
        //model.addAttribute("productList", productService.getList(productPage));

        ProductVo productVo = productService.get(productNumber);

        List<OptionVo> optionList = new ArrayList<>();

        Stack<OptionVo> treeStack = new Stack<>();
        for(OptionVo option : productVo.getOptions())
            treeStack.push(option);

        while (!treeStack.isEmpty()) {
            OptionVo oVo = treeStack.pop();
            //oVo.setProductNumber(prodNum);
            optionList.add(oVo);
            //optionList.put(oVo.getProductNumber())

            if (oVo.getSubOptions() == null)
                continue;

//            for (int i = oVo.getSubOptions().size(); i > 0; i--) {
//                OptionVo subOVo = oVo.getSubOptions().get(i - 1);
//                subOVo.setParentOptionNumber(oVo.getOptionNumber());
//                treeStack.push(subOVo);
//            }

            for (OptionVo subOption : oVo.getSubOptions()){
                //subOption.setParentOptionNumber(oVo.getOptionNumber());
                treeStack.push(subOption);
            }
        }
//        for(OptionVo oVo : optionList){
//            System.out.println(oVo);
//        }
        model.addAttribute("productVo", productVo);
        model.addAttribute("optionList", optionList);
        return "product/item";
    }
}
