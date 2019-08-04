package com.cafe24.mall.controller;

import com.cafe24.dto.JsonResult;
import com.cafe24.mall.repository.OrderDao;
import com.cafe24.mall.service.OrderService;
import com.cafe24.mall.vo.OrderDetailsVo;
import com.cafe24.mall.vo.OrderVo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderDao orderDao;
    @Autowired
    OrderService orderService;
    @Test
    @Transactional
    public void testGetList() throws Exception{
        for (int i = 0; i < 20; i++) {
            OrderVo testVo = new OrderVo();
            testVo.setUserNumber(1L);
            testVo.setOrderPostNumber("12345");
            testVo.setOrderAddr("즐거운우리집");
            testVo.setOrdererName("getListControllerTest"+i);
            testVo.setOrdererPhone("01012345678");
            orderDao.registry(testVo);
        }

        mockMvc.perform(get("/order/list/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is("success")))
                .andDo(print());
    }

    @Test
    @Transactional
    public void testAdd() throws Exception{
        OrderVo testVo = new OrderVo();
        testVo.setUserNumber(1L);
        testVo.setOrderPostNumber("12345");
        testVo.setOrderAddr("즐거운우리집");
        testVo.setOrdererName("getControllerTest");
        testVo.setOrdererPhone("01012345678");
        OrderDetailsVo testOdsVo = new OrderDetailsVo();
        testOdsVo.setOptionNumber(178L);
        testOdsVo.setOrderDetailsCount(2L);
        testVo.addGoods(testOdsVo);

        mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(testVo))
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.result", is("success")));
    }

    @Test
    @Transactional
    public void testGet() throws Exception{
        OrderVo testVo = new OrderVo();
        testVo.setUserNumber(1L);
        testVo.setOrderPostNumber("12345");
        testVo.setOrderAddr("즐거운우리집");
        testVo.setOrdererName("getControllerTest");
        testVo.setOrdererPhone("01012345678");
        OrderDetailsVo testOdsVo = new OrderDetailsVo();
        testOdsVo.setOptionNumber(178L);
        testOdsVo.setOrderDetailsCount(2L);
        testVo.addGoods(testOdsVo);

        Assert.assertTrue(orderService.add(testVo));

        String resJsonStr=
        mockMvc.perform(get("/order/"+testVo.getOrderNumber()))
                .andExpect(jsonPath("$.result", is("success")))
                .andReturn()
                .getResponse()
                .getContentAsString();

        //JsonResult jsonResult = new Gson().fromJson(resJsonStr, JsonResult.class);
        //OrderVo resVo = new Gson().fromJson(jsonResult.getData().toString(), new TypeToken<List<OrderVo>>(){}.getType());
        //OrderVo resVo = (OrderVo)jsonResult.getData();
    }

    @Test
    @Transactional
    public void testCancel() throws Exception {
        OrderVo testVo = new OrderVo();
        testVo.setUserNumber(1L);
        testVo.setOrderPostNumber("12345");
        testVo.setOrderAddr("즐거운우리집");
        testVo.setOrdererName("getControllerTest");
        testVo.setOrdererPhone("01012345678");
        OrderDetailsVo testOdsVo = new OrderDetailsVo();
        testOdsVo.setOptionNumber(178L);
        testOdsVo.setOrderDetailsCount(2L);
        testVo.addGoods(testOdsVo);

        Assert.assertTrue(orderService.add(testVo));

        mockMvc.perform(delete("/order/"+testVo.getOrderNumber()))
                .andExpect(jsonPath("$.result", is("success")));

        Assert.assertEquals("주문취소",orderDao.get(testVo.getOrderNumber(),1L).getOrderState());
    }
}
