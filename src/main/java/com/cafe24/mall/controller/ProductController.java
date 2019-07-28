package com.cafe24.mall.controller;

import com.cafe24.dto.JsonResult;
import com.cafe24.mall.service.ProductService;
import com.cafe24.mall.vo.ProductVo;
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

        ResponseEntity res;

        if(productService.add(pVo))
            res = ResponseEntity.status(HttpStatus.CREATED).body(JsonResult.success(null));
        else
            res = ResponseEntity.status(500).body(JsonResult.fail("add fail"));
        return res;
    }

    @GetMapping("/{productNo}")
    public String viewProductDetail(@PathVariable(value="productNo") Long prodNum){
        // TODO : implementation
        return null;
    }

    // move to front
    @Deprecated
    @GetMapping("/{productNo}/modify")
    public String modifyProductForm(@PathVariable(value="productNo") Long id){
        // TODO : implementation, add permission
        return null;
    }

    @PutMapping("/{productNo:[\\d]+}")
    public String modifyProduct(@ModelAttribute ProductVo productNo){
        // TODO : implementation, permission check
        return null;
    }

    @DeleteMapping("/{productNo:[\\d]+}")
    public ResponseEntity deleteProduct(@PathVariable Long productNo){
        // TODO : add permission
        ResponseEntity res = null;
        if(productService.delete(productNo))
            res = ResponseEntity.status(200).body(null);
        else
            res = ResponseEntity.status(500).body(null);
        return res;
    }
}
