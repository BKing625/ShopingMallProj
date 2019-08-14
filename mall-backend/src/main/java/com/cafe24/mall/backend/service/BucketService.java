package com.cafe24.mall.backend.service;

import com.cafe24.mall.backend.repository.BucketDao;
import com.cafe24.mall.backend.vo.BucketVo;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BucketService {
    private final BucketDao bucketDao;

    public BucketService(BucketDao bucketDao) {
        this.bucketDao = bucketDao;
    }

    public boolean add(BucketVo bucVo) {
        if (bucVo.getNonMemberId() == null &&
                bucVo.getUserNumber() == null)
            return false;

        return bucketDao.registry(bucVo)>0;
    }

    public boolean delete(Long delNum){
        BucketVo bucVo = new BucketVo();
        bucVo.setBucketNumber(delNum);
        return 1==bucketDao.delete(bucVo);
    }

    public List<BucketVo> getList(BucketVo bucVo){

        return bucketDao.getList(bucVo);
    }

    public boolean changeCount(BucketVo bucVo){
        if(bucVo.getUserNumber()==null || bucVo.getBucketCount() < 1)
            return false;
        return  1== bucketDao.update(bucVo);
    }

    public boolean deleteByUser(Long userNumber) {
        BucketVo bucVo = new BucketVo();
       bucVo.setUserNumber(userNumber);
        return 0<bucketDao.delete(bucVo);
    }
}
