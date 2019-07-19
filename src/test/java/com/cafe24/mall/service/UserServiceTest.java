package com.cafe24.mall.service;

import com.cafe24.mall.MallApplication;
import com.cafe24.mall.vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

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
        userService.add(testVo);

        assertNull(null);
        UserVo condiUserInfo = new UserVo();
        condiUserInfo.setUserId("get@test.com");
        assertNotNull(userService.getInfo(condiUserInfo));
    }

    @Test
    public void testGetUserList(){
        UserVo testUserVo = new UserVo();
        testUserVo.setUserName("안뇽");
        testUserVo.setUserId("getlist@test.com");
        testUserVo.setUserPassword("1234");
        userService.add(testUserVo);

        UserVo testUserVo2 = new UserVo();
        testUserVo2.setUserName("안뇽");
        testUserVo2.setUserId("getlist2@test.com");
        testUserVo2.setUserPassword("1234");
        userService.add(testUserVo2);
        assertTrue(userService.getList(1).size()>1);
    }


    @Test
    public void testUpdateUserInfo(){
        UserVo testUserVo = new UserVo();
        testUserVo.setUserName("안뇽");
        testUserVo.setUserId("update@test.com");
        testUserVo.setUserPassword("1234");

        userService.add(testUserVo);

        testUserVo.setUserTall(17160);
        userService.modify(testUserVo);

        UserVo conditionVo = new UserVo();
        conditionVo.setUserId(testUserVo.getUserId());
        assertEquals((Integer)17160,userService.getInfo(conditionVo).getUserTall());

    }


    @Test
    public void testDelete(){
        UserVo testVo = new UserVo();
        testVo.setUserId("deleteService@test.com");
        testVo.setUserName("BK");
        testVo.setUserPassword("1234");
        userService.add(testVo);
        assertNotNull(userService.getInfo(testVo));

        userService.delete(testVo);
        assertNull(userService.getInfo(testVo));
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
    }
}
