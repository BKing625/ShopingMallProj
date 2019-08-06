package com.cafe24.mall.backend.repository;

import com.cafe24.mall.backend.repository.OrderDao;
import com.cafe24.mall.backend.vo.OrderVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "classpath:application.properties")//classes= MallApplication.class)
@Transactional
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    public void testRegistry(){
        OrderVo testVo = new OrderVo();
        testVo.setUserNumber(1L);
        testVo.setOrderPostNumber("12345");
        testVo.setOrderAddr("즐거운우리집");
        testVo.setOrdererName("regTest");
        testVo.setOrdererPhone("01012345678");

        Assert.assertEquals(1, (int) orderDao.registry(testVo));
    }

    @Test
    public void testGetList(){
        for (int i = 0; i < 20; i++) {
            OrderVo testVo = new OrderVo();
            testVo.setUserNumber(1L);
            testVo.setOrderPostNumber("12345");
            testVo.setOrderAddr("즐거운우리집");
            testVo.setOrdererName("getListTest"+i);
            testVo.setOrdererPhone("01012345678");
            orderDao.registry(testVo);
        }

        List<OrderVo> resVos = orderDao.getList(1L,1);
//        for(OrderVo a : resVos){
//            System.out.println(a);
//        }
        Assert.assertTrue(resVos.size()>=2);
        Assert.assertNotNull(resVos.get(0));
    }

    @Test
    public void testUpdate() {
        OrderVo testVo = new OrderVo();
        testVo.setUserNumber(1L);
        testVo.setOrderPostNumber("12345");
        testVo.setOrderAddr("즐거운우리집");
        testVo.setOrdererName("modiTest");
        testVo.setOrdererPhone("01012345678");
        orderDao.registry(testVo);

        testVo.setOrdererName("modified");
        Assert.assertEquals((Integer) 1, orderDao.update(testVo));

        Assert.assertEquals("modified",
                orderDao.get(testVo.getOrderNumber(),1L).getOrdererName());

        //Assert.assertEquals(testVo, orderDao.get(testVo.getProductNumber()));
    }

    @Test
    public void testGet() {
        OrderVo testVo = new OrderVo();
        testVo.setUserNumber(1L);
        testVo.setOrderPostNumber("12345");
        testVo.setOrderAddr("즐거운우리집");
        testVo.setOrdererName("getTest");
        testVo.setOrdererPhone("01012345678");
        orderDao.registry(testVo);
        OrderVo gotVo = orderDao.get(testVo.getOrderNumber(),testVo.getUserNumber());
        Assert.assertEquals(testVo.getOrderAddr(), gotVo.getOrderAddr());
        Assert.assertEquals(testVo.getOrdererPhone(), gotVo.getOrdererPhone());
    }
}
