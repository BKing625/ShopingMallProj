package com.cafe24.mall.repository;

import com.cafe24.mall.vo.OrderVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDao {
    private final SqlSession sqlSession;

    public OrderDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Integer registry(OrderVo orderVo) {
        // TODO : exception processing
        try {
            return sqlSession.insert("order.registry", orderVo);
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public List<OrderVo> getList(long userNumber, int page) {
        Map<String ,Object> map = new HashMap<>();
        map.put("userNumber", userNumber);
        map.put("page", 15*(page-1));
        try {
            return sqlSession.selectList("order.getList", map);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Integer update(OrderVo updateVo) {
        return sqlSession.update("order.update", updateVo);
    }

    public OrderVo get(Long orderNumber, Long userNumber) {
        Map<String ,Long> map = new HashMap<>();
        map.put("orderNumber", orderNumber);
        map.put("userNumber", userNumber);
        return sqlSession.selectOne("order.get", map);
    }
}
