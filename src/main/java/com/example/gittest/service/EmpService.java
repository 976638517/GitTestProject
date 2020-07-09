package com.example.gittest.service;

import com.example.gittest.bean.DeptVo;
import com.example.gittest.bean.EmpVo;

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
    List<EmpVo> selectEmpByDate();
    //查询by sal
    List<EmpVo> selectEmpBySal();
    //查询by comm
    List<EmpVo> selectEmpByComm();
    //查询by depno

    //增加
    int addEmp(EmpVo empVo);
    //删除
    int deleteEmp(EmpVo empVo);
    //改
    int updateEmp(EmpVo empVo);
}
