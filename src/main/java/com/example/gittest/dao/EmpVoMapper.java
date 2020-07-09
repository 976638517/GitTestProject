package com.example.gittest.dao;

import com.example.gittest.bean.EmpVo;
import com.example.gittest.bean.EmpVoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmpVoMapper {
    long countByExample(EmpVoExample example);

    int deleteByExample(EmpVoExample example);

    int insert(EmpVo record);

    int insertSelective(EmpVo record);

    List<EmpVo> selectByExample(EmpVoExample example);

    int updateByExampleSelective(@Param("record") EmpVo record, @Param("example") EmpVoExample example);

    int updateByExample(@Param("record") EmpVo record, @Param("example") EmpVoExample example);

    @Select("select *from emp")
    List<EmpVo> selectAll();
}