package com.cafe24.mall.service;

import com.cafe24.dto.JsonResult;
import com.cafe24.mall.vo.UserVo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserService.class})
public class UserServiceTest {

    // TODO : Add more test cases, implement methods

    @Autowired
    UserService userService;

    @Test
    public void userServiceDI(){
        assertNotNull(userService);
    }

    @Ignore
    @Test
    public void testGetUserList(){
        // TODO : implement test
    }


    @Test
    public void testAddUser(){
        // TODO : implement test
        UserVo testVo = new UserVo();
        testVo.setUserNumber(111L);
        userService.add(testVo);
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

    @Ignore
    @Test
    public void testGetListTest(){


        assertTrue(false);
    }

    @Ignore
    @Test
    public void testExistId(){
        assertTrue(userService.existId("uniqueId"));
//
//        assertThat(JsonResult.success(false))
//                .isEqualTo(userService.existId("dupEmail"));

    }
}
