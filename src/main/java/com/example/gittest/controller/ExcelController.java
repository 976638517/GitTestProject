package com.example.gittest.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.example.gittest.bean.DataYuan;
import com.example.gittest.bean.EmpVo;
import com.example.gittest.util.DealDoc;
import com.example.gittest.service.ServiceImpl.EmpServiceImpl;
import com.example.gittest.util.ExcelUtil;
import com.example.gittest.util.NormalException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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


    @RequestMapping("/exportdata")
    public void exportdata(HttpServletResponse response){
        String filePath = "C:\\Users\\july\\Desktop\\test.doc";
        //模拟从数据库获取需要导出的数据
        List<DataYuan> list=DealDoc.read(filePath);
        for (DataYuan dataYuan:list){
            System.out.println(dataYuan);
        }
        ExportParams exportParams = new ExportParams("龙华经济数据中台数据元", "sheet");
        exportParams.setType(ExcelType.XSSF);
        Workbook workbook=ExcelExportUtil.exportExcel(exportParams,DataYuan.class,list);

        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode("aaa", "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new NormalException(e.getMessage());
        }
    }
}




