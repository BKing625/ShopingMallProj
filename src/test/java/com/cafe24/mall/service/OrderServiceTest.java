package com.cafe24.mall.service;

import com.cafe24.mall.repository.OrderDao;
import com.cafe24.mall.vo.OrderDetailsVo;
import com.cafe24.mall.vo.OrderVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "classpath:application.properties")
@Transactional
public class OrderServiceTest {
    @Autowired OrderService orderService;
    @Autowired
    OrderDao orderDao;
    @Test
    public void testAdd(){
        OrderVo testVo = new OrderVo();
        testVo.setUserNumber(1L);
        testVo.setOrderPostNumber("12345");
        testVo.setOrderAddr("즐거운우리집");
        testVo.setOrdererName("addTest");
        testVo.setOrdererPhone("01012345678");

        OrderDetailsVo testOdsVo = new OrderDetailsVo();
        testOdsVo.setOptionNumber(178L);
        testOdsVo.setOrderDetailsCount(2L);
        testVo.addGoods(testOdsVo);

        Assert.assertTrue(orderService.add(testVo));
    }

    @Test
    public void testCancel(){
        OrderVo testVo = new OrderVo();
        testVo.setUserNumber(1L);
        testVo.setOrderPostNumber("12345");
        testVo.setOrderAddr("즐거운우리집");
        testVo.setOrdererName("addTest");
        testVo.setOrdererPhone("01012345678");
        OrderDetailsVo testOdsVo = new OrderDetailsVo();
        testOdsVo.setOptionNumber(178L);
        testOdsVo.setOrderDetailsCount(2L);
        testVo.addGoods(testOdsVo);
        Assert.assertTrue(orderService.add(testVo));
        orderService.cancel(testVo);

        Assert.assertEquals("주문취소",
                orderService.get(testVo.getOrderNumber(),1L).getOrderState());
    }

    @Test
    public void testGet(){
        OrderVo testVo = new OrderVo();
        testVo.setUserNumber(1L);
        testVo.setOrderPostNumber("12345");
        testVo.setOrderAddr("즐거운우리집");
        testVo.setOrdererName("getTest");
        testVo.setOrdererPhone("01012345678");

        OrderDetailsVo testOdsVo = new OrderDetailsVo();
        testOdsVo.setOptionNumber(178L);
        testOdsVo.setOrderDetailsCount(2L);
        testVo.addGoods(testOdsVo);

        Assert.assertTrue(orderService.add(testVo));

        //Assert.assertEquals(testVo, orderService.get(testVo.getOrderNumber(),1L));
        Assert.assertEquals(testVo.getOrderAddr(),
                orderService.get(testVo.getOrderNumber(),1L).getOrderAddr());

        Assert.assertEquals(testVo.getGoodsList(),
                orderService.get(testVo.getOrderNumber(),1L).getGoodsList());
    }

    @Test
    public void testGetList(){
        for (int i = 0; i < 20; i++) {
            OrderVo testVo = new OrderVo();
            testVo.setUserNumber(1L);
            testVo.setOrderPostNumber("12345");
            testVo.setOrderAddr("즐거운우리집");
            testVo.setOrdererName("getListServiceTest"+i);
            testVo.setOrdererPhone("01012345678");
            orderDao.registry(testVo);
        }

        List<OrderVo> resVos = orderService.getList(1L,1);
//        for(OrderVo tVo : resVos){
//            System.out.println(tVo);
//        }
        Assert.assertTrue(resVos.size()==15);
        Assert.assertNotNull(resVos.get(0));
        Assert.assertEquals("getListServiceTest0", resVos.get(0).getOrdererName());
    }
}
