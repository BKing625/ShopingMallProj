package com.cafe24.mall.frontend.controller;

import com.cafe24.mall.frontend.dto.ProductSimpleViewDto;
import com.cafe24.mall.frontend.service.BucketService;
import com.cafe24.mall.frontend.service.OrderService;
import com.cafe24.mall.frontend.service.ProductService;
import com.cafe24.mall.frontend.vo.OrderDetailsVo;
import com.cafe24.mall.frontend.vo.OrderVo;
import com.cafe24.mall.frontend.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    BucketService bucketService;
    @Autowired
    ProductService productService;

    @GetMapping("{orderNumber:[\\d]+}")
    public String orderDetail(HttpSession httpSession, @PathVariable Long orderNumber, Model model){
        UserVo userVo = (UserVo) httpSession.getAttribute("authUserInfo");
        if (userVo == null) return "redirect:/1";

        OrderVo orderVo = orderService.get(userVo.getUserNumber(), orderNumber);
        if(orderVo==null)
            return "redirect:/";

        List<ProductSimpleViewDto> psvdList = productService.getByOrderDetails(orderVo.getGoodsList());
        if(psvdList==null)
            return "redirect:/";
        model.addAttribute("orderVo",orderVo);
        model.addAttribute("productList",psvdList);
        //ProductSimpleViewDto psvd = orderService.getOrderDetails(orderNumber);
        return "order/detail";
    }
    @PostMapping("")
    public String addOrder(HttpSession httpSession, @ModelAttribute OrderVo orderVo, Model model) {
        UserVo userVo = (UserVo) httpSession.getAttribute("authUserInfo");
        if (userVo == null) return "redirect:/1";
//        for(OrderDetailsVo vo : orderVo.getGoodsList()){
//            System.out.println(vo);
//        }
        Long res = orderService.addOrder(orderVo);
        if (res > 0) {
            bucketService.deleteByUser(userVo.getUserNumber());
            return "redirect:/order/" + res.toString();
        }
        else
            return "redirect:/";
    }

    @PostMapping("/pre")
    public String orderForm(HttpSession httpSession, @ModelAttribute ProductSimpleViewDto psvdt, Model model) {
        UserVo userVo = (UserVo) httpSession.getAttribute("authUserInfo");
        if (userVo == null) return "redirect:/1";

        model.addAttribute("productList", psvdt.getProductSimpleViewDtoList());
        return "order/orderForm";
    }

    @GetMapping("/list/{orderPage:[\\d]+}")
    public String orderList(HttpSession httpSession, @PathVariable Integer orderPage, Model model){

        UserVo userVo = (UserVo) httpSession.getAttribute("authUserInfo");
        if (userVo == null) return "redirect:/1";

        List<OrderVo> orderList = orderService.getList(userVo.getUserNumber(), orderPage);

//        for(UserVo uv:userList){
//            System.out.println(uv);
//        }
        model.addAttribute("orderList",orderList);
        return "order/list";
    }
}
