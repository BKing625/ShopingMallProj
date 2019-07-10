package com.cafe24.mall;

import com.cafe24.dto.JsonResult;
import com.cafe24.mall.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserService.class})
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void userServiceDI(){
        assertNotNull(userService);
    }

    @Test
    public void idDuplicateCheck(){


        assertThat(JsonResult.success(true))
                .isEqualTo(userService.existEmail("uniqueEmail"));

        assertThat(JsonResult.success(false))
                .isEqualTo(userService.existEmail("dupEmail"));

    }
}
