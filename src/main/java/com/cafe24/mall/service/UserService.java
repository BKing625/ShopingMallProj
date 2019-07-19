package com.cafe24.mall.service;

import com.cafe24.mall.repository.UserDao;
import com.cafe24.mall.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserDao userDao;
    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Boolean modify(UserVo userVo){
        return (1 == userDao.update(userVo));
    }

    // TODO : encryption
    public Boolean add(UserVo userVo){
        return userDao.registry(userVo) == 1;
    }

    public Boolean delete(UserVo userVo){
        return (userDao.delete(userVo) == 1);
    }

    public UserVo login(UserVo userVo){
        return null;
    }

    public List<UserVo> getList(){
        return getList(1);
    }

    public List<UserVo> getList(int page){
        return userDao.getList(page);
    }

    public UserVo getInfo(UserVo conditionVo){
        if(conditionVo == null)return null;
        if (conditionVo.getUserNumber() == null && conditionVo.getUserId() == null) return null;
        return userDao.get(conditionVo);
    }

    public List<UserVo> search(String keyword){
        return null;
    }

    public Boolean existId(String userId){
        return userDao.getByUserId(userId) != null;
    }
}
