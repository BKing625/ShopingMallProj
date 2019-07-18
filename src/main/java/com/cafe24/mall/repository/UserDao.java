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

    // TODO : modfiy test case
    public UserVo get(UserVo conditionVo){
        if(conditionVo.getUserNumber() == null && conditionVo.getUserId() == null) return null;
        return sqlSession.selectOne("user.get", conditionVo);
    }

    public UserVo getByUserNumber(Long userNum){
        UserVo inputVo = new UserVo();
        inputVo.setUserNumber(userNum);
        return sqlSession.selectOne("user.get", inputVo);
    }

    public UserVo getByUserId(String userId){
        UserVo inputVo = new UserVo();
        inputVo.setUserId(userId);
        return sqlSession.selectOne("user.get", inputVo);
    }
    public UserVo getByUserIdAndPwd(String userId, String pwd){
        UserVo inputVo = new UserVo();
        inputVo.setUserId(userId);
        inputVo.setUserPassword(pwd);
        return sqlSession.selectOne("user.get", inputVo);
    }

}
