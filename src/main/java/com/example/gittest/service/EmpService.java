package com.example.gittest.service;

import com.example.gittest.bean.DeptVo;
import com.example.gittest.bean.EmpVo;

import javax.xml.crypto.Data;
import java.util.List;

public interface EmpService {
    //查询所有
    List<EmpVo> selectEmpAll();
    //查询by id
    List<EmpVo> selectEmpByEmpno(Integer empno);
    //查询by name
    List<EmpVo> selectEmpByEmame(String ename);
    //查询by job
    List<EmpVo> selectEmpByJob(String job);
    //查询by mgr
    List<EmpVo> selectEmpByMgr(Integer mgr);
    //查询入职时间
    List<EmpVo> selectEmpByDate(String a,String b);
    //查询by 小于等于sal
    List<EmpVo> selectEmpBySal(Integer sal);
    //查询by 大于等于comm
    List<EmpVo> selectEmpByComm(Integer comm);
    //查询by deptno
    List<EmpVo> empAndDept(Integer id);
    //按照dept查询
    List<DeptVo> selectDeptAndEmp();

    //增加
    int addEmp(EmpVo empVo);
    //删除
    int deleteEmp(EmpVo empVo);
    //改
    int updateEmp(EmpVo empVo);
}
