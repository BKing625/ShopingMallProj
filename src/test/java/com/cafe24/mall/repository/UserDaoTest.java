package com.cafe24.mall.repository;

import com.cafe24.mall.MallApplication;
import com.cafe24.mall.vo.UserVo;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MallApplication.class)
@Transactional
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    private static List<UserVo> testUserVoList;

    @BeforeClass
    public static void setUp(){
        testUserVoList = new ArrayList<>();
        UserVo testUserVo = new UserVo();
        testUserVo.setUserName("병관테스트");
        testUserVo.setUserId("c@b.c");
        testUserVo.setUserPassword("1234");
        testUserVoList.add(testUserVo);

        testUserVo = new UserVo();
        testUserVo.setUserName("병관테스트");
        testUserVo.setUserId("c@b.c");
        testUserVo.setUserPassword("1234");
        testUserVoList.add(testUserVo);
    }

    @Test
    public void testRegistry() {
        //insert
        assertThat(userDao.registry(testUserVoList.get(0)), is(1));
        //dup insert
        assertThat(userDao.registry(testUserVoList.get(1)), is(0));
    }

    @Test
    public void testGetByUserNumber(){
        UserVo testUserVo = new UserVo();
        testUserVo.setUserName("안뇽");
        testUserVo.setUserId("select@test.com");
        testUserVo.setUserPassword("1234");
        userDao.registry(testUserVo);

        UserVo getUserVo = userDao.getByUserNumber(testUserVo.getUserNumber());

        // TODO : set written date into input vo
        getUserVo.setUserJoinDate(null);
        assertEquals(testUserVo, getUserVo);
    }

    @Test
    public void testGetByUserId(){
        UserVo testUserVo = new UserVo();
        testUserVo.setUserName("안뇽");
        testUserVo.setUserId("selectid@test.com");
        testUserVo.setUserPassword("1234");
        userDao.registry(testUserVo);

        UserVo getUserVo = userDao.getByUserId("selectid@test.com");

        // TODO : set written date into input vo
        getUserVo.setUserJoinDate(null);
        assertEquals(testUserVo, getUserVo);
    }

    @Test
    public void testGetByUserIdAndPwd(){
        UserVo testUserVo = new UserVo();
        testUserVo.setUserName("안뇽");
        testUserVo.setUserId("selectidpwd@test.com");
        testUserVo.setUserPassword("1234");
        userDao.registry(testUserVo);

        UserVo getUserVo = userDao.getByUserIdAndPwd("selectidpwd@test.com","1234");

        // TODO : set written date into input vo
        getUserVo.setUserJoinDate(null);
        assertEquals(testUserVo, getUserVo);

        UserVo falsePwdUserVo = userDao.getByUserIdAndPwd("selectidpwd@test.com","1");
        assertNull(falsePwdUserVo);
    }
}