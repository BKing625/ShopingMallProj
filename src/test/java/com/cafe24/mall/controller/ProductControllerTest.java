package com.cafe24.mall.controller;

import com.cafe24.mall.repository.ProductDao;
import com.cafe24.mall.service.ProductService;
import com.cafe24.mall.vo.OptionVo;
import com.cafe24.mall.vo.ProductVo;
import com.google.gson.Gson;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductService productService;


    @Test
    public void testTemplateDI(){

        Assert.assertNotNull(mockMvc);
    }

    @Test
    @Transactional
    public void testAddProduct() throws Exception{

        ProductVo testVo = new ProductVo();

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

        mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(testVo))
                .characterEncoding("utf-8"))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));

        testVo.setProductName("addTest");
        mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(testVo))
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.result", is("success")));
    }

    @Test
    @Transactional
    public void testGetList() throws Exception{
        for (int i = 0; i < 20; i++) {
            ProductVo testVo = new ProductVo();
            testVo.setProductName("getListTest" + i);
            testVo.setProductStockType(ProductVo.StockType.LIMIT);
            productDao.registry(testVo);
        }

        mockMvc.perform(get("/product/list/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is("success")))
                .andDo(print());
    }

    @Test
    @Transactional
    public void testDelete() throws Exception{
        ProductVo testVo = new ProductVo();

        testVo.setProductStockType(ProductVo.StockType.LIMIT);
        List<OptionVo> testOptionVo = new ArrayList<>();

        OptionVo testOptionVo11 = new OptionVo();
        testOptionVo11.setOptionDetail("child1");
        OptionVo testOptionVo12 = new OptionVo();
        testOptionVo12.setOptionDetail("child2");
        OptionVo testOptionVo21 = new OptionVo();
        testOptionVo21.setOptionDetail("1child1");
        OptionVo testOptionVo22 = new OptionVo();
        testOptionVo22.setOptionDetail("1child2");

        testOptionVo11.addChildren(testOptionVo21);
        testOptionVo11.addChildren(testOptionVo22);
        testOptionVo.add(testOptionVo11);
        testOptionVo.add(testOptionVo12);

        testVo.setOptions(testOptionVo);
        testVo.setProductName("delTest");
        Assert.assertTrue(productService.add(testVo));

        Long testVoNum = testVo.getProductNumber();

        mockMvc.perform(delete("/product/"+testVoNum))
                .andExpect(status().isOk())
                .andDo(print());

        mockMvc.perform(delete("/product/"+testVoNum))
                .andExpect(status().isInternalServerError())
                .andDo(print());
    }

    @Test
    @Transactional
    public void testGet() throws Exception{
        ProductVo testVo = new ProductVo();

        testVo.setProductStockType(ProductVo.StockType.LIMIT);
        List<OptionVo> testOptionVo = new ArrayList<>();

        OptionVo testOptionVo11 = new OptionVo();
        testOptionVo11.setOptionDetail("child1");
        OptionVo testOptionVo12 = new OptionVo();
        testOptionVo12.setOptionDetail("child2");
        OptionVo testOptionVo21 = new OptionVo();
        testOptionVo21.setOptionDetail("1child1");
        OptionVo testOptionVo22 = new OptionVo();
        testOptionVo22.setOptionDetail("1child2");

        testOptionVo11.addChildren(testOptionVo21);
        testOptionVo11.addChildren(testOptionVo22);
        testOptionVo.add(testOptionVo11);
        testOptionVo.add(testOptionVo12);

        testVo.setOptions(testOptionVo);
        testVo.setProductName("getTest");
        Assert.assertTrue(productService.add(testVo));

        Long testVoNum = testVo.getProductNumber();

        mockMvc.perform(get("/product/"+testVoNum))
                .andExpect(jsonPath("$.result", is("success")))
                .andDo(print());
    }

    @Test
    @Transactional
    public void testModify() throws Exception{
        ProductVo testVo = new ProductVo();

        testVo.setProductStockType(ProductVo.StockType.LIMIT);
        List<OptionVo> testOptionVo = new ArrayList<>();

        OptionVo testOptionVo11 = new OptionVo();
        testOptionVo11.setOptionDetail("child1");
        OptionVo testOptionVo12 = new OptionVo();
        testOptionVo12.setOptionDetail("child2");
        OptionVo testOptionVo21 = new OptionVo();
        testOptionVo21.setOptionDetail("1child1");
        OptionVo testOptionVo22 = new OptionVo();
        testOptionVo22.setOptionDetail("1child2");

        testOptionVo11.addChildren(testOptionVo21);
        testOptionVo11.addChildren(testOptionVo22);
        testOptionVo.add(testOptionVo11);
        testOptionVo.add(testOptionVo12);

        testVo.setOptions(testOptionVo);
        testVo.setProductName("modifyTest");
        Assert.assertTrue(productService.add(testVo));

        Long testVoNum = testVo.getProductNumber();
        testVo.setProductName("modified");
        mockMvc.perform(put("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(testVo))
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        Assert.assertEquals("modified",productDao.get(testVoNum).getProductName());
    }
}
