package com.example.gittest.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.example.gittest.bean.AA;
import com.example.gittest.bean.DataYuan;
import com.example.gittest.bean.EmpVo;
import com.example.gittest.bean.rowPojo;
import com.example.gittest.util.DealDoc;
import com.example.gittest.service.ServiceImpl.EmpServiceImpl;
import com.example.gittest.util.ExcelUtil;
import com.example.gittest.util.NormalException;
import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.NoSuchElementException;

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


    @RequestMapping("/importExcelgetList")
    public void importExcellist(){
        String filePath = "C:\\Users\\july\\Desktop\\data.xls";
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        params.setTitleRows(0);
        List<rowPojo> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), rowPojo.class, params);
        }catch (NoSuchElementException e){
            throw new NormalException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            throw new NormalException(e.getMessage());
        }

        List<AA> list1= Lists.newLinkedList();
        for (int i=0;i<list.size();i=i+3){
            AA aa=new AA();
            aa.setName(list.get(i).getStr());
            aa.setType(list.get(i+1).getStr());
            aa.setComment(list.get(i+2).getStr());
            list1.add(aa);
        }

        //TODO 保存数据库
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\july\\Desktop\\data.xls";
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        params.setTitleRows(0);

        List<rowPojo> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), rowPojo.class, params);
        }catch (NoSuchElementException e){
            throw new NormalException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            throw new NormalException(e.getMessage());
        }

        List<AA> list1= Lists.newLinkedList();
        for (int i=0;i<list.size();i=i+3){
            AA aa=new AA();
            aa.setName(list.get(i).getStr());
            aa.setType("` varchar(100) DEFAULT NULL COMMENT '");
            aa.setComment(list.get(i+2).getStr());
            list1.add(aa);
        }
//        CREATE TABLE `o_dp_ent_detail` (
//          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
//          `entuniorgcode_btime` varchar(100) DEFAULT NULL COMMENT '开始时间',
//          `entuniorgcode_code` varchar(100) DEFAULT NULL COMMENT '统一信用代码',
//          `entuniorgcode_no` varchar(100) DEFAULT NULL COMMENT '组织机构代码',
//          `entuniorgcode_org` varchar(100) DEFAULT NULL COMMENT '代码证颁证机关',
//          `entuniorgcode_idate` varchar(100) DEFAULT NULL COMMENT '代码证颁证日期',
//          `entuniorgcode_cdate` varchar(100) DEFAULT NULL COMMENT '代码证废置日期',
//          `entuniorgcode_flag` varchar(100) DEFAULT NULL COMMENT '代码证废置标记',
//          `entuniorgcode_item` varchar(100) DEFAULT NULL COMMENT '代码证变更事项',
//          `entuniorgcode_content` varchar(100) DEFAULT NULL COMMENT '代码证变更内容',
//          `entuniorgcode_chdate` varchar(100) DEFAULT NULL COMMENT '代码证变更日期',
//          `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
//          `modify_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//                PRIMARY KEY (`id`),
//                KEY `entuniorgcode_code_indes` (`entuniorgcode_code`) USING BTREE COMMENT '统一社会信用代码'
//        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

        StringBuilder sb = new StringBuilder();
        for (AA aa:
             list1) {
            sb.append("`");
            sb.append(aa.getName());
            sb.append(aa.getType());
            sb.append(aa.getComment());
            sb.append("',");
        }
        System.out.println(sb);;
    }
}




