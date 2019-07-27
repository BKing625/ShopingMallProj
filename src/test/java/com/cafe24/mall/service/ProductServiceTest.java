package com.cafe24.mall.service;

import com.cafe24.mall.repository.ProductDao;
import com.cafe24.mall.vo.OptionVo;
import com.cafe24.mall.vo.ProductVo;
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
public class ProductServiceTest {

    @Autowired
    ProductService productService;
    @Autowired
    ProductDao productDao;
    @Test
    public void testDI(){
        Assert.assertNotNull(productService);
    }

    @Test
    public void testAdd(){
        ProductVo testVo = new ProductVo();
        testVo.setProductName("addTest");
        testVo.setProductStockType(ProductVo.StockType.LIMIT);
        List<OptionVo> testOptionVo = new ArrayList<>();

        OptionVo testOptionVo11 = new OptionVo();
        testOptionVo11.setOptionDetail("child1");
        OptionVo testOptionVo12 = new OptionVo();
        testOptionVo12.setOptionDetail("child2");
        OptionVo testOptionVo21 = new OptionVo();
        testOptionVo21.setOptionDetail("1child1");

        testOptionVo11.addChildren(testOptionVo21);
        testOptionVo.add(testOptionVo11);
        testOptionVo.add(testOptionVo12);

        testVo.setOptions(testOptionVo);

        Assert.assertTrue(productService.add(testVo));
    }

    @Test
    public void testGetUserList(){
        for (int i = 0; i < 20; i++) {
            ProductVo testVo = new ProductVo();
            testVo.setProductName("getListTest" + i);
            testVo.setProductStockType(ProductVo.StockType.LIMIT);
            productDao.registry(testVo);
        }
        Assert.assertEquals(15, productService.getList(1).size());
    }
}
