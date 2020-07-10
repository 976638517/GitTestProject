package com.example.gittest.controller;

import com.example.gittest.bean.DeptVo;
import com.example.gittest.bean.EmpVo;
import com.example.gittest.service.ServiceImpl.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmpController {

    @Autowired
    EmpServiceImpl empService;
    @RequestMapping("/selectEmpAll")
    List<EmpVo> selectEmpByEmpno(){
        return empService.selectEmpAll();
    }
    @RequestMapping("/selectEmpByEmpno")
    List<EmpVo> selectEmpByEmpno(@RequestParam(name = "empno") Integer empon){
        return empService.selectEmpByEmpno(empon);
    }
    @RequestMapping("/selectEmpByEmame")
    List<EmpVo> selectEmpByEmame(@RequestParam(name = "ename") String ename){
        return empService.selectEmpByEmame(ename);
    }
    @RequestMapping("/selectEmpByJob")
    List<EmpVo> selectEmpByJob(@RequestParam(name = "job") String job){
        return empService.selectEmpByJob(job);
    }
    @RequestMapping("/selectEmpByMgr")
    List<EmpVo> selectEmpByMgr(@RequestParam(name = "mgr") Integer mgr){
        return empService.selectEmpByMgr(mgr);
    }
    @RequestMapping("/selectEmpByDate")
    List<EmpVo> selectEmpByDate(@RequestParam(name = "a") String a,@RequestParam(name = "b") String b){
        return empService.selectEmpByDate(a,b);
    }
    @RequestMapping("/selectEmpBySal")
    List<EmpVo> selectEmpBySal(@RequestParam(name = "sal") Integer sal){

        return empService.selectEmpBySal(sal);
    }
    @RequestMapping("/selectEmpByComm")
    List<EmpVo> selectEmpByComm(@RequestParam(name = "comm") Integer comm){
        return empService.selectEmpByComm(comm);
    }

    @RequestMapping("/addEmp")
    boolean addEmp(EmpVo empVo){
        if (empService.addEmp(empVo)!=0)
            return true;
        else
            return false;
    }
    @RequestMapping("/deleteEmp")
    boolean deleteEmp(EmpVo empVo){
        if (empService.deleteEmp(empVo)!=0)
            return true;
        else
            return false;
    }
    @RequestMapping("/updateEmp")
    boolean updateEmp(EmpVo empVo){
        if (empService.updateEmp(empVo)!=0)
            return true;
        else
            return false;
    }
    @RequestMapping("/empAndDept")
    List<EmpVo> empAndDept(@RequestParam(name = "id") Integer comm){
        return empService.empAndDept(comm);
    }
    @RequestMapping("/selectDeptAndEmp")
    List<DeptVo> selectDeptAndEmp(){
        return empService.selectDeptAndEmp();
    }

    @RequestMapping("/selectBywhere")
    List<EmpVo> selectBywhere(EmpVo empVo) {
        return empService.selectBywhere(empVo);
    }

    @RequestMapping("/updataBySet")
    Boolean updataBySet(EmpVo empVo) {
        if (empService.updataBySet(empVo)!=0)
            return true;
        else
            return false;
    }

    //传入collection如何
    @RequestMapping(value = "insertDeptlist",method = RequestMethod.POST)
    int insertDeptlist(@RequestParam(name = "deptlist") List<DeptVo> deptlist) {

        return empService.insertDeptlist(deptlist);
    }

}
