package com.cafe24.mall.controller;

import com.cafe24.mall.service.UserService;
import com.cafe24.mall.vo.UserVo;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Test
    public void testTemplateDi() {
        assertNotNull(mockMvc);
        assertNotNull(userService);
    }

    @Test
    @Transactional
    public void testJoinUser() throws Exception {

        UserVo testVo = new UserVo();
        testVo.setUserId("userjoin@test.com");
        testVo.setUserName("BK");

        // valid test
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(testVo))
                .characterEncoding("utf-8"))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));

        // join test
        testVo.setUserPassword("1234");
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(testVo))
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        //exception test : duplicated id
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(testVo))
                .characterEncoding("utf-8"))
                .andExpect(status().isInternalServerError())
                .andDo(print())
                .andExpect(jsonPath("$.result", is("fail")))
                .andExpect(jsonPath("$.message", is("add fail")));
    }

    @Test
    @Transactional
    public void testIdCheck() throws Exception {
        UserVo testVo = new UserVo();
        testVo.setUserId("idcheck@test.com");
        testVo.setUserName("BK");
        testVo.setUserPassword("1234");
        // valid test
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(testVo))
                .characterEncoding("utf-8"));

        mockMvc.perform(get("/users/idcheck")
                .content("idcheck@test.com")
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is("fail")));

        mockMvc.perform(get("/users/idcheck")
                .content("idcheck2@test.com")
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is("success")));

        mockMvc.perform(get("/users/idcheck")
                .content("idcheck2test.com")
                .characterEncoding("utf-8"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void testGetUserList() throws Exception {
        UserVo testVo = new UserVo();
        testVo.setUserId("getUser@test.com");
        testVo.setUserName("BK");
        testVo.setUserPassword("1234");

        UserVo testVo2 = new UserVo();
        testVo2.setUserId("getUser2@test.com");
        testVo2.setUserName("BK");
        testVo2.setUserPassword("1234");

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(testVo))
                .characterEncoding("utf-8"));

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(testVo2))
                .characterEncoding("utf-8"));

        mockMvc.perform(get("/users/list/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is("success")))
                .andDo(print());
    }

    @Test
    @Transactional
    public void testDelete() throws Exception{
        UserVo testVo = new UserVo();
        testVo.setUserId("delete@test.com");
        testVo.setUserName("BK");
        testVo.setUserPassword("1234");

        userService.add(testVo);

        mockMvc.perform(MockMvcRequestBuilders.delete("/users/"+testVo.getUserNumber()))
                .andExpect(status().isOk());

        assertNull(userService.getInfo(testVo));
    }

    @Test
    @Transactional
    public void testModifyUser() throws Exception{
        UserVo testVo = new UserVo();
        testVo.setUserId("modify@test.com");
        testVo.setUserName("BK");
        testVo.setUserPassword("1234");

        userService.add(testVo);

        testVo.setUserName("modified");
        testVo.setUserPassword(null);
        mockMvc.perform(MockMvcRequestBuilders.put("/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(testVo))
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        testVo.setUserName(null);
        testVo = userService.getInfo(testVo);
        assertEquals("modified",testVo.getUserName());
    }
}
