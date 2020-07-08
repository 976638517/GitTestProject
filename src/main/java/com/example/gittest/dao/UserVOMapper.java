package com.example.gittest.dao;

import com.example.gittest.bean.UserVOExample;
import java.util.List;

import com.example.gittest.bean.UserVo;
import org.apache.ibatis.annotations.Param;

public interface UserVOMapper {
    long countByExample(UserVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserVo record);

    int insertSelective(UserVo record);

    List<UserVo> selectByExample(UserVOExample example);

    UserVo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserVo record, @Param("example") UserVOExample example);

    int updateByExample(@Param("record") UserVo record, @Param("example") UserVOExample example);

    int updateByPrimaryKeySelective(UserVo record);

    int updateByPrimaryKey(UserVo record);
}