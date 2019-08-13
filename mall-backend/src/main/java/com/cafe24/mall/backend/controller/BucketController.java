package com.cafe24.mall.backend.controller;

import com.cafe24.dto.JsonResult;
import com.cafe24.mall.backend.service.BucketService;
import com.cafe24.mall.backend.vo.BucketVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bucket")
public class BucketController {
    private  final BucketService bucketService;

    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @GetMapping("/user/{userNo:[\\d]+}")
    public JsonResult getBucket(@PathVariable Long userNo){

        BucketVo bucVo = new BucketVo();

        // TODO: 2019-08-04 user auth
        bucVo.setUserNumber(userNo);
        return JsonResult.success(bucketService.getList(bucVo));
    }

    @PostMapping("")
    public ResponseEntity addBucket( @RequestBody @Valid BucketVo bVo,
                                     BindingResult result){
        if(result.hasErrors()) {
            List<ObjectError> errors=result.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.toString());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(JsonResult.fail(error.getDefaultMessage()));
            }
        }
        ResponseEntity res;

        if(bucketService.add(bVo))
            res = ResponseEntity.status(HttpStatus.CREATED).body(JsonResult.success(null));
        else
            res = ResponseEntity.status(500).body(JsonResult.fail("add fail"));
        return res;
    }

    @DeleteMapping("/{bucketNo:[\\d]+}")
    public ResponseEntity delete(@PathVariable Long bucketNo) {
        ResponseEntity res = null;
        if(bucketService.delete(bucketNo))
            res = ResponseEntity.status(200).body(null);
        else
            res = ResponseEntity.status(500).body(null);
        return res;
    }

    @PutMapping("")
    public ResponseEntity changeCount(@RequestBody @Valid BucketVo bVo,
                                      BindingResult result) {
        ResponseEntity res;
        if(bucketService.changeCount(bVo))
            res = ResponseEntity.status(200).body(JsonResult.success(null));
        else
            res = ResponseEntity.status(500).body(JsonResult.fail("modify fail"));
        return res;
    }


}
