package com.cafe24.mall.repository;


import com.cafe24.mall.vo.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private final SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Integer registry(UserVo userVo) {
        // TODO : exception processing
        try {
            return sqlSession.insert("user.registry", userVo);
        }
        catch (Exception e){
            e.fillInStackTrace();
            return 0;
        }
    }
}
