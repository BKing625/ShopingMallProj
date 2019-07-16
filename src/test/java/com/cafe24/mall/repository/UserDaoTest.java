package com.cafe24.mall.repository;

import com.cafe24.mall.MallApplication;
import com.cafe24.mall.vo.UserVo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MallApplication.class)
@Transactional
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    UserVo testUserVo;
    @BeforeClass
    public void setUp(){
        testUserVo = new UserVo();
        
    }

    @Test
    public void abc(){
        System.out.println(userDao.registry(null));
    }
}
