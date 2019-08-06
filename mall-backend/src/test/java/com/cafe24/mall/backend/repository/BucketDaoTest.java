package com.cafe24.mall.backend.repository;

import com.cafe24.mall.backend.vo.BucketVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "classpath:application.properties")//classes= MallApplication.class)
@Transactional
public class BucketDaoTest {
    @Autowired
    private BucketDao bucketDao;

    @Test
    public void testRegistry(){
        BucketVo testVo = new BucketVo();

        testVo.setBucketCount(1L);
        testVo.setUserNumber(1L);
        testVo.setOptionNumber(178L);

        Assert.assertEquals((Integer)1,bucketDao.registry(testVo));
    }

}
