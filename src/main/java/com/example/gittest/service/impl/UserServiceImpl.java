package com.example.gittest.service.impl;

import com.example.gittest.bean.UserVOExample;
import com.example.gittest.bean.UserVo;
import com.example.gittest.dao.UserDao;
import com.example.gittest.dao.UserVOMapper;
import com.example.gittest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserVOMapper userVOMapper;




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
        UserVo userVo = userVOMapper.selectByPrimaryKey(Integer.parseInt(userName));
        return userDao.findByName(userName);
    }



    @Override
    public List<UserVo> findAll() {
        UserVOExample example=new UserVOExample();
        UserVOExample.Criteria criteria=example.createCriteria();
        criteria.andIdIsNotNull();

        return userVOMapper.selectByExample(example);
    }

    @Override
    public boolean addUserMapper(UserVo userVo) {
        if (userVOMapper.insert(userVo)!=0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteUserMapper(UserVo userVo) {
        if (userVOMapper.deleteByPrimaryKey(userVo.getId())!=0)
            return true;
        else
            return false;
    }

    @Override
    public List<UserVo> findUserByIdMaapper(int id) {
        UserVOExample example=new UserVOExample();
        UserVOExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(id);
        return userVOMapper.selectByExample(example);
    }

    @Override
    public List<UserVo> findUserByNameMaapper(String name) {
        UserVOExample example=new UserVOExample();
        UserVOExample.Criteria criteria=example.createCriteria();
        criteria.andNameEqualTo(name);
        return userVOMapper.selectByExample(example);
    }

    @Override
    public List<UserVo> findUserByAgeMaapper(int age) {
        UserVOExample example=new UserVOExample();
        UserVOExample.Criteria criteria=example.createCriteria();
        criteria.andAgeEqualTo(age);
        return userVOMapper.selectByExample(example);
    }

    @Override
    public boolean updataUserMapper(UserVo userVo) {
        if(userVOMapper.updateByPrimaryKey(userVo)!=0)
            return true;
        else
            return false;
    }
}
