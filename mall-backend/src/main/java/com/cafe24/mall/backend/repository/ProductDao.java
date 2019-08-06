package com.cafe24.mall.backend.repository;

import com.cafe24.mall.backend.vo.ProductVo;
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
            e.printStackTrace();
            return 0;
        }
    }

    public List<ProductVo> getList(int page){
        return sqlSession.selectList("product.getList",15*(page-1));
    }

    public ProductVo get(Long productId){
        return sqlSession.selectOne("product.get", productId);
    }

    public Integer delete(Long productId){

        return sqlSession.delete("product.delete",productId);
    }

    public Integer update(ProductVo updateVo) {
        return sqlSession.update("product.update", updateVo);
    }
}
