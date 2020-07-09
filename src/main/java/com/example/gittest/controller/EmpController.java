package com.example.gittest.controller;

import com.example.gittest.bean.EmpVo;
import com.example.gittest.service.ServiceImpl.EmpServiceImpl;
import org.hibernate.bytecode.enhance.internal.bytebuddy.EnhancerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/selectEmpByEmame/{ename}")
    List<EmpVo> selectEmpByEmame(@PathVariable(name = "ename") String ename){
        return empService.selectEmpByEmame(ename);
    }
    @RequestMapping("/selectEmpByJob/{job}")
    List<EmpVo> selectEmpByJob(@PathVariable(name = "job") String job){
        return empService.selectEmpByJob(job);
    }
    @RequestMapping("/selectEmpByMgr/{mgr}")
    List<EmpVo> selectEmpByMgr(@PathVariable(name = "mgr") Integer mgr){
        return empService.selectEmpByMgr(mgr);
    }


}
