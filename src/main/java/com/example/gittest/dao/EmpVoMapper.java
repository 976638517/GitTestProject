package com.example.gittest.dao;

import com.example.gittest.bean.EmpVo;
import com.example.gittest.bean.EmpVoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmpVoMapper {
    long countByExample(EmpVoExample example);

    int deleteByExample(EmpVoExample example);

    int deleteByPrimaryKey(Integer empno);

    int insert(EmpVo record);

    int insertSelective(EmpVo record);

    List<EmpVo> selectByExample(EmpVoExample example);

    EmpVo selectByPrimaryKey(Integer empno);

    int updateByExampleSelective(@Param("record") EmpVo record, @Param("example") EmpVoExample example);

    int updateByExample(@Param("record") EmpVo record, @Param("example") EmpVoExample example);

    int updateByPrimaryKeySelective(EmpVo record);

    int updateByPrimaryKey(EmpVo record);
    @Select("select *from emp")
    List<EmpVo> selectAll();

    List<EmpVo> empAndDept(@Param("id")Integer id);

}