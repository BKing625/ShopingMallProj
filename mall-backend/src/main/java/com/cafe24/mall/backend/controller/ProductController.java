package com.cafe24.mall.backend.controller;

import com.cafe24.dto.JsonResult;
import com.cafe24.mall.backend.service.ProductService;
import com.cafe24.mall.backend.vo.ProductVo;
import com.oracle.tools.packager.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list/{productPage:[\\d]+}")
    public JsonResult viewProductList(@PathVariable Integer productPage){
        return JsonResult.success(productService.getList(productPage));
    }

    @Deprecated
    @GetMapping("/new")
    public String registerProductForm(){
        // TODO : implementation, add permission
        return null;
    }


    @PostMapping("")
    public ResponseEntity addProduct(@RequestBody @Valid ProductVo pVo,
                                                 BindingResult result){
        // TODO : add permission
        if(result.hasErrors()) {
            List<ObjectError> errors=result.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.toString());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(JsonResult.fail(error.getDefaultMessage()));
            }
        }
        Log.debug(pVo.toString());

        ResponseEntity res;

        if(productService.add(pVo))
            res = ResponseEntity.status(HttpStatus.CREATED).body(JsonResult.success(pVo.getProductNumber()));
        else
            res = ResponseEntity.status(500).body(JsonResult.fail("add fail"));
        return res;
    }

    @GetMapping("/{productNo}")
    public JsonResult viewProductDetail(@PathVariable(value="productNo") Long prodNum){
        ProductVo resVo = productService.get(prodNum);
        if(resVo!=null){
            return JsonResult.success(resVo);
        } else {
            return JsonResult.fail("invalid product number");
        }
    }

    // move to front
    @Deprecated
    @PutMapping("")
    public ResponseEntity modifyProduct(@RequestBody @Valid ProductVo prodVo,
                                                    BindingResult result){
        // TODO : permission check
        if(result.hasErrors()) {
            List<ObjectError> errors=result.getAllErrors();
            for (ObjectError error : errors) {
                if ("pwd must not be empty".equals(error.getDefaultMessage())) {
                    System.out.println(error.toString());
                    continue;
                }
                System.out.println(error.getDefaultMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(JsonResult.fail(error.getDefaultMessage()));
            }
        }

        ResponseEntity res;
        if(productService.modify(prodVo))
            res = ResponseEntity.status(200).body(JsonResult.success(null));
        else
            res = ResponseEntity.status(500).body(JsonResult.fail("modify fail"));
        return res;
    }

    @DeleteMapping("/{productNo:[\\d]+}")
    public ResponseEntity deleteProduct(@PathVariable Long productNo){
        // TODO : add permission
        ResponseEntity res;
        if(productService.delete(productNo))
            res = ResponseEntity.status(200).body(null);
        else
            res = ResponseEntity.status(500).body(null);
        return res;

    }

    @GetMapping("/option/{optionNo:[\\d]+}")
    public JsonResult getProductViewType(@PathVariable Long optionNo){

        ProductVo resVo = productService.getProductNumberByOption(optionNo);
        if(resVo!=null){
            return JsonResult.success(resVo);
        } else {
            return JsonResult.fail("invalid product number");
        }
    }
}
