package com.cafe24.mall.backend.repository;

import com.cafe24.mall.backend.vo.OrderDetailsVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailsDao {
    private final SqlSession sqlSession;
    public OrderDetailsDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Integer registry(OrderDetailsVo odsVo) {
        // TODO : exception processing
        try {
            return sqlSession.insert("orderdetails.registry", odsVo);
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public List<OrderDetailsVo> getList(Long orderNum){
        return sqlSession.selectList("orderdetails.getList", orderNum);
    }

    public Integer update(OrderDetailsVo updateVo) {
        return sqlSession.update("orderdetails.update", updateVo);
    }
}
