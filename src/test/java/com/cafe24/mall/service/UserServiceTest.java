package com.cafe24.mall.service;

import com.cafe24.dto.JsonResult;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
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

    @Ignore
    @Test
    public void testAddUser(){
        // TODO : implement test
    }

    @Ignore
    @Test
    public void testUpdateUserInfo(){
        // TODO : implement test
    }

    @Ignore
    @Test
    public void testDeleteUser(){
        // TODO : implement test
    }

    @Ignore
    @Test
    public void testExistId(){
        assertThat(JsonResult.success(true))
                .isEqualTo(userService.existId("uniqueEmail"));

        assertThat(JsonResult.success(false))
                .isEqualTo(userService.existId("dupEmail"));
    }
}
