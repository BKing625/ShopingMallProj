package com.cafe24.mall.repository;

import com.cafe24.mall.vo.ProductVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    private final SqlSession sqlSession;
    public ProductDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Integer registry(ProductVo productVo) {
        // TODO : exception processing
        try {
            return sqlSession.insert("product.registry", productVo);
        }
        catch (Exception e){
            e.fillInStackTrace();
            return 0;
        }
    }

    public List<ProductVo> getList(int page){
        return sqlSession.selectList("product.getList",15*(page-1));
    }

    public ProductVo get(Long productId){
        return sqlSession.selectOne("product.get", productId);
    }

    public Integer delete(ProductVo delVo){
        return sqlSession.delete("product.delete",delVo);
    }

    public Integer update(ProductVo updateVo) {
        return sqlSession.update("product.update", updateVo);
    }
}
