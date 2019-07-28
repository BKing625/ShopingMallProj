package com.cafe24.mall.repository;

import com.cafe24.mall.service.ProductService;
import com.cafe24.mall.vo.ProductVo;
import io.swagger.models.auth.In;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "classpath:application.properties")//classes= MallApplication.class)
@Transactional
public class ProductDaoTest {
    @Autowired
    ProductDao productDao;

    @Test
    public void testDI() {
        Assert.assertNotNull(productDao);
    }

    @Test
    public void testRegistry() {
        ProductVo testVo = new ProductVo();
        testVo.setProductName("insert test");
        testVo.setProductStockType(ProductVo.StockType.LIMIT);

        Assert.assertEquals(1, (int) productDao.registry(testVo));
    }

    @Test
    public void testGet() {
        ProductVo testVo = new ProductVo();
        testVo.setProductName("get test");
        testVo.setProductStockType(ProductVo.StockType.LIMIT);
        productDao.registry(testVo);
        Assert.assertEquals(testVo, productDao.get(testVo.getProductNumber()));
    }

    @Test
    public void testDelete() {
        ProductVo testVo = new ProductVo();
        testVo.setProductName("del test");
        testVo.setProductStockType(ProductVo.StockType.LIMIT);

        productDao.registry(testVo);
        Assert.assertEquals((Integer) 1, productDao.delete(testVo.getProductNumber()));
        Assert.assertNull(productDao.get(testVo.getProductNumber()));
    }

    @Test
    public void testUpdate() {
        ProductVo testVo = new ProductVo();
        testVo.setProductName("modify test");
        testVo.setProductStockType(ProductVo.StockType.LIMIT);

        productDao.registry(testVo);

        testVo.setProductName("modified");
        Assert.assertEquals((Integer) 1, productDao.update(testVo));

        Assert.assertEquals(testVo, productDao.get(testVo.getProductNumber()));
    }

    @Test
    public void testGetList() {
        for (int i = 0; i < 20; i++) {
            ProductVo testVo = new ProductVo();
            testVo.setProductName("getListTest" + i);
            testVo.setProductStockType(ProductVo.StockType.LIMIT);
            productDao.registry(testVo);
        }

        List<ProductVo> gotVos = productDao.getList(1);
//        for (ProductVo gotVo:gotVos
//        ) {
//            System.out.println(gotVo);
//        }
        Assert.assertEquals(15, gotVos.size());
    }
}
