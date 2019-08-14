package com.cafe24.mall.backend.controller;

import com.cafe24.dto.JsonResult;
import com.cafe24.mall.backend.vo.OrderVo;
import com.cafe24.mall.backend.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/list/{userNumber:[\\d]+}/{orderPage:[\\d]+}")
    public JsonResult getOrderList(@PathVariable Long userNumber, @PathVariable Integer orderPage){
        // add permission
        // TODO: 2019-08-01 future work
        // = getUserNumber : fail (500 or 403)
        return JsonResult.success(orderService.getList(userNumber, orderPage));
    }

    @GetMapping("/{userNumber:[\\d]+}/{orderNumber:[\\d]+}")
    public JsonResult getOrderDetail(@PathVariable Long userNumber, @PathVariable Long orderNumber){

        OrderVo resVo = orderService.get(orderNumber,userNumber);
        //System.out.println(resVo);
        if(resVo!=null){
            return JsonResult.success(resVo);
        } else {
            return JsonResult.fail("invalid order number");
        }
    }

    @PostMapping("")
    public ResponseEntity addOrder(@RequestBody OrderVo addVo){
        //add validation

        if(orderService.add(addVo))
            return ResponseEntity.status(200).body(JsonResult.success(addVo.getOrderNumber()));
        else
            return ResponseEntity.status(500).body(JsonResult.fail("add fail"));
    }

    @DeleteMapping("/{orderNumber:[\\d]+}")
    public ResponseEntity cancelOrder(@PathVariable Long orderNumber){
        //add validation
        Long userNumber = 1L;

        OrderVo cancelVo = new OrderVo();
        cancelVo.setOrderNumber(orderNumber);
        cancelVo.setUserNumber(userNumber);

        if(orderService.cancel(cancelVo))
            return ResponseEntity.status(200).body(JsonResult.success(null));
        else
            return ResponseEntity.status(500).body(JsonResult.fail("update fail"));
    }
}
