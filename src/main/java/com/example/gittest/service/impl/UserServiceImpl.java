package com.example.gittest.service.impl;

import com.example.gittest.bean.UserVo;
import com.example.gittest.dao.UserDao;
import com.example.gittest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUser(UserVo userVo) {
        boolean flag=false;
        try{
            userDao.addUser(userVo);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateUser(UserVo userVo) {
        boolean flag=false;
        try{
            userDao.updateUser(userVo);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean flag=false;
        try{
            userDao.deleteUser(id);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public UserVo findUserByName(String userName) {
        return userDao.findByName(userName);
    }

    @Override
    public List<UserVo> findAll() {
        return userDao.findAll();
    }
}
