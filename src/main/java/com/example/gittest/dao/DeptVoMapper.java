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

//按照dept查询查询每个部门里面是emplist
// {
//        "deptno": 20,
//        "dname": "RESEARCH",
//        "loc": "DALLAS",
//        "empVoList": [
//            {
//                "empno": 7369,
//                "ename": "SMITH",
//                "job": "CLERK",
//                "mgr": 7902,
//                "hiredate": "1980-12-16T16:00:00.000+00:00",
//                "sal": 800,
//                "comm": null,
//                "deptno": 20,
//                "deptVo": null
//            },
//            {
//                "empno": 7566,
//                "ename": "JONES",
//                "job": "MANAGER",
//                "mgr": 7839,
//                "hiredate": "1981-04-01T16:00:00.000+00:00",
//                "sal": 2975,
//                "comm": null,
//                "deptno": 20,
//                "deptVo": null
//            },
//            {
//                "empno": 7788,
//                "ename": "SCOTT",
//                "job": "ANALYST",
//                "mgr": 7566,
//                "hiredate": "1987-04-18T15:00:00.000+00:00",
//                "sal": 3000,
//                "comm": null,
//                "deptno": 20,
//                "deptVo": null
//            },
//            {
//                "empno": 7876,
//                "ename": "ADAMS",
//                "job": "CLERK",
//                "mgr": 7788,
//                "hiredate": "1987-05-22T15:00:00.000+00:00",
//                "sal": 1100,
//                "comm": null,
//                "deptno": 20,
//                "deptVo": null
//            },
//            {
//                "empno": 7902,
//                "ename": "FORD",
//                "job": "ANALYST",
//                "mgr": 7566,
//                "hiredate": "1981-12-02T16:00:00.000+00:00",
//                "sal": 3000,
//                "comm": null,
//                "deptno": 20,
//                "deptVo": null
//            }
//        ]
//    }
    List<DeptVo> selectDeptAndEmp();

    int insertDeptlist(@Param("deptlist") List<DeptVo> deptlist);
}