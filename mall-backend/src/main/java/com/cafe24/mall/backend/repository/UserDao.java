package com.cafe24.mall.backend.repository;


import com.cafe24.mall.backend.vo.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import java.util.List;

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

            e.printStackTrace();

            return 0;
        }
    }

    public UserVo get(UserVo conditionVo){
        if(conditionVo.getUserNumber() == null && conditionVo.getUserId() == null) return null;
        return sqlSession.selectOne("user.get", conditionVo);
    }

    public List<UserVo> getList(int page){

        try {
            return sqlSession.selectList("user.getList", (page - 1) * 15);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

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

    public Integer delete(UserVo userVo) {
        if (userVo.getUserNumber() == null)
            return 0;
        return sqlSession.delete("user.delete", userVo);
    }

    public Integer update(UserVo userVo) {
        if(userVo.getUserNumber()==null || userVo.getUserId() ==null)
            return 0;
        return sqlSession.update("user.update", userVo);
    }

}
