package com.cafe24.mall.service;

import com.cafe24.mall.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    public Boolean modify(UserVo userVo){
        return null;
    }

    // TODO : encryption
    public Boolean add(UserVo userVo){
        return null;
    }

    public Boolean delete(UserVo userVo){
        return null;
    }

    public UserVo login(UserVo userVo){
        return null;
    }

    public List<UserVo> getList(){
        return getList(1);
    }

    public List<UserVo> getList(int page){
        return null;
    }
    public List<UserVo> search(String keyword){
        return null;
    }
    public Boolean existId(String userId){
        // TODO : implementation
        return true;
    }
}
