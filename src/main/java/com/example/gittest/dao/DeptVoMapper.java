package com.example.gittest.dao;

import com.example.gittest.bean.DeptVo;
import com.example.gittest.bean.DeptVoExample;
import java.util.List;

import com.example.gittest.bean.EmpVo;
import org.apache.ibatis.annotations.Param;

public interface DeptVoMapper {
    long countByExample(DeptVoExample example);

    int deleteByExample(DeptVoExample example);

    int deleteByPrimaryKey(Integer deptno);

    int insert(DeptVo record);

    int insertSelective(DeptVo record);

    List<DeptVo> selectByExample(DeptVoExample example);

    DeptVo selectByPrimaryKey(Integer deptno);

    int updateByExampleSelective(@Param("record") DeptVo record, @Param("example") DeptVoExample example);

    int updateByExample(@Param("record") DeptVo record, @Param("example") DeptVoExample example);

    int updateByPrimaryKeySelective(DeptVo record);

    int updateByPrimaryKey(DeptVo record);

    List<EmpVo> selectEmpbydeptno(@Param("id")Integer id);

    List<DeptVo> selectDeptAndEmp();
}