package com.cafe24.mall.repository;

import com.cafe24.mall.vo.OrderDetailsVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "classpath:application.properties")//classes= MallApplication.class)
@Transactional
public class OrderDetailsDaoTest {

    @Autowired OrderDetailsDao odsDao;

    @Test
    public void testRegistry(){
        OrderDetailsVo testVo = new OrderDetailsVo();
        testVo.setOptionNumber(178L);
        testVo.setOrderNumber(190L);
        testVo.setOrderDetailsCount(1L);

        Assert.assertEquals(1, (int) odsDao.registry(testVo));
        //Assert.assertEquals(testVo, odsDao.get(testVo.getProductNumber()));
    }

    @Test
    public void testGetList(){
        OrderDetailsVo testVo = new OrderDetailsVo();
        testVo.setOptionNumber(178L);
        testVo.setOrderNumber(190L);
        testVo.setOrderDetailsCount(1L);

        Assert.assertEquals(1, (int) odsDao.registry(testVo));

        Assert.assertEquals(1, odsDao.getList(190L).size());
    }
}
