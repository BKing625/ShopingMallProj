package com.cafe24.mall.repository;


import com.cafe24.mall.vo.OptionVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "classpath:application.properties")//classes= MallApplication.class)
@Transactional
public class OptionDaoTest {
    @Autowired private  OptionDao optionDao;

    @Test
    public void testDI(){
        assertNotNull(optionDao);
    }
    @Test
    public void testRegistry(){
        OptionVo testVo = new OptionVo();
        testVo.setProductNumber(1L);
        testVo.setOptionDetail("S");

        Assert.assertEquals(1, (int) optionDao.registry(testVo));
    }

    @Test
    public void testGetList(){
        OptionVo testVo = new OptionVo();
        testVo.setProductNumber(1L);
        testVo.setOptionDetail("GetTestParent");
        OptionVo testVo2 = new OptionVo();
        testVo2.setProductNumber(1L);
        testVo2.setOptionDetail("GetTestChild");

        optionDao.registry(testVo);

        testVo2.setParentOptionNumber(testVo.getOptionNumber());

        optionDao.registry(testVo2);

        List<OptionVo> resVos = optionDao.getList(1L);

        Assert.assertTrue(resVos.size()>=2);
        Assert.assertNotNull(resVos.get(0));
    }

    @Test
    public void testDelete(){
        OptionVo testVo = new OptionVo();
        testVo.setProductNumber(1L);
        testVo.setOptionDetail("GetTestParent");
        OptionVo testVo2 = new OptionVo();
        testVo2.setProductNumber(1L);
        testVo2.setOptionDetail("GetTestChild");

        optionDao.registry(testVo);

        testVo2.setParentOptionNumber(testVo.getOptionNumber());

        optionDao.registry(testVo2);
        optionDao.delete(1L);
        assertEquals(0, optionDao.getList(1L).size());
    }
}
