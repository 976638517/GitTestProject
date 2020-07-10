package com.example.gittest.controller;

import ch.qos.logback.core.util.FileUtil;
import com.example.gittest.bean.EmpVo;
import com.example.gittest.service.ServiceImpl.EmpServiceImpl;
import com.example.gittest.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
@RestController
public class ExcelController {
    @Autowired
    EmpServiceImpl empService;
    @RequestMapping("/export")
    public void export(HttpServletResponse response){

        //模拟从数据库获取需要导出的数据
        List<EmpVo> list=empService.selectEmpAll();

        //导出操作
        ExcelUtil.exportExcel(list,"emp表","emp",EmpVo.class,"emp.xls",response);
    }

    @RequestMapping("/importExcel")
    public void importExcel(){
        String filePath = "D:\\emp.xls";
        //解析excel，
        List<EmpVo> List = ExcelUtil.importExcel(filePath,1,1,EmpVo.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+empService.insertEmplist(List)+"】行");

        //TODO 保存数据库

    }
}
