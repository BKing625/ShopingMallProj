package com.cafe24.mall.repository;

import com.cafe24.mall.vo.BucketVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BucketDao {

    private final SqlSession sqlSession;

    public BucketDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Integer registry(BucketVo bucVo) {
        // TODO : exception processing
        try {
            return sqlSession.insert("bucket.registry", bucVo);
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public List<BucketVo> getList(BucketVo bucVo) {
        Map<String ,Object> map = new HashMap<>();
        if(bucVo.getUserNumber()!=null)
            map.put("userNumber",bucVo.getUserNumber());
        if(bucVo.getNonMemberId()!=null)
            map.put("nonMemberId",bucVo.getNonMemberId());
        try {
            return sqlSession.selectList("bucket.getList", map);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Integer delete(Long bucketNum){
        if (bucketNum == null)
            return 0;
        return sqlSession.delete("bucket.delete", bucketNum);
    }
    public Integer update(BucketVo bucVo){
        return sqlSession.update("bucket.update",bucVo);
    }
}
