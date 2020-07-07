package com.example.gittest.dao;

import com.example.gittest.bean.UserVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {


        // 用户数据新增

        @Insert("insert into t_user(id,name,age) values (#{id},#{name},#{age})")
        void addUser(UserVo userVo);

        // 用户数据修改

        @Update("update t_user set name=#{name},age=#{age} where id=#{id}")
        void updateUser(UserVo userVo);

        // 用户数据删除

        @Delete("delete from t_user where id=#{id}")
        void deleteUser(int id);

        //根据用户名称查询用户信息

        @Select("SELECT id,name,age FROM t_user where name=#{userName}")
        UserVo findByName(@Param("userName") String userName);

        //查询所有

        @Select("SELECT id,name,age FROM t_user")
        List<UserVo> findAll();



}
