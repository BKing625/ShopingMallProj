package com.cafe24.mall.service;

import com.cafe24.dto.JsonResult;
import com.cafe24.mall.MallApplication;
import com.cafe24.mall.vo.UserVo;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MallApplication.class})
@Transactional
public class UserServiceTest {

    // TODO : Add more test cases, implement methods

    @Autowired
    UserService userService;

    @Test
    public void userServiceDI(){
        assertNotNull(userService);
    }

    @Test
    public void testAddUser(){
        UserVo testVo = new UserVo();
        testVo.setUserId("addService@test.com");
        testVo.setUserName("BK");
        testVo.setUserPassword("1234");
        assertTrue(userService.add(testVo));
    }

    @Test
    public void getUserInfoTest(){
        UserVo testVo = new UserVo();
        testVo.setUserId("get@test.com");
        testVo.setUserName("BK");
        testVo.setUserPassword("1234");


    }
    @Ignore
    @Test
    public void testGetUserList(){
        // TODO : implement test
    }




    @Ignore
    @Test
    public void testUpdateUserInfo(){
        // TODO : implement test
    }

    @Ignore
    @Test
    public void testDelete(){
        UserVo testVo = new UserVo();
        testVo.setUserNumber(111L);
        userService.delete(testVo);
        assertTrue(false);
    }

    @Test
    public void testExistId(){
        UserVo testVo = new UserVo();
        testVo.setUserId("duplicatedId@test.com");
        testVo.setUserName("BK");
        testVo.setUserPassword("1234");
        userService.add(testVo);


        assertFalse(userService.existId("uniqueId@test.com"));
        assertTrue(userService.existId("duplicatedId@test.com"));
//
//        assertThat(JsonResult.success(false))
//                .isEqualTo(userService.existId("dupEmail"));

    }
}
