package com.example.gittest.service;

import com.example.gittest.bean.UserVo;

import java.util.List;

public interface UserService {
    // 新增用户 * @param user * @return
    boolean addUser(UserVo userVo);
    //** * 修改用户 * @param user * @return */
    boolean updateUser(UserVo userVo );
    //** * 删除用户 * @param id * @return */
    boolean deleteUser(int id);
    //** * 根据用户名字查询用户信息 * @param userName */
    UserVo findUserByName(String userName);
    /** * 查询所有 * @return */
    List<UserVo> findAll();
}
