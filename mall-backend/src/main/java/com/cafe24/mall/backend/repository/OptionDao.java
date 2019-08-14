package com.cafe24.mall.backend.repository;

import com.cafe24.mall.backend.vo.OptionVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OptionDao {

    private final SqlSession sqlSession;
    public OptionDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Integer registry(OptionVo optionVo) {
        // TODO : exception processing
        try {
            return sqlSession.insert("option.registry", optionVo);
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public List<OptionVo> getList(Long productId){
        return sqlSession.selectList("option.getList", productId);
    }

    public Integer delete(Long productId){
        return sqlSession.delete("option.delete", productId);
    }

    public Long getProductNumByOption(Long optionNo) {
        return sqlSession.selectOne("option.getByOptionNum", optionNo);
    }
}
