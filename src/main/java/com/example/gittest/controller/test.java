package com.example.gittest.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.example.gittest.bean.SqlXlsxBean;
import com.example.gittest.bean.TbaleXlsxBean;
import com.example.gittest.bean.ZiDuanBean;
import com.example.gittest.pojo.SqlTable;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.Lists;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String url_tb = "C:\\Users\\july\\Desktop\\tianyancha\\tablename.xlsx";
        String url_zd = "C:\\Users\\july\\Desktop\\tianyancha\\ziduan.xlsx";
        String url_field = "C:\\Users\\july\\Desktop\\tianyancha\\field.xlsx";
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        List<TbaleXlsxBean> tbaleXlsxBeanList = ExcelImportUtil.importExcel(
                new File(url_tb),
                TbaleXlsxBean.class, params);
        System.out.println("###########" + tbaleXlsxBeanList);
        List<ZiDuanBean> ziDuanBeanList = ExcelImportUtil.importExcel(
                new File(url_zd),
                ZiDuanBean.class, params);
        System.out.println("###########" + ziDuanBeanList.size());
        System.out.println("###########" + ziDuanBeanList);
        List<SqlXlsxBean> sqlXlsxBeanList = Lists.newArrayList();
        for (int i = 0; i < ziDuanBeanList.size(); i++) {
            int id = 500 + i;
            TbaleXlsxBean tbean = null;
            for (TbaleXlsxBean tbaleXlsxBean :
                    tbaleXlsxBeanList) {
                if (tbaleXlsxBean.getZwbm().equals(ziDuanBeanList.get(i).getBm())){
                    tbean = tbaleXlsxBean;
                    break;
                }

            }
            SqlXlsxBean sqlXlsxBean = new SqlXlsxBean(id + "", ziDuanBeanList.get(i), tbean);
            sqlXlsxBeanList.add(sqlXlsxBean);
        }
        for (SqlXlsxBean tb :
                sqlXlsxBeanList) {
            System.out.println(tb);
        }
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(url_field);
            ExportParams exportParams = new ExportParams();
            exportParams.setType(ExcelType.XSSF);

            Workbook workbook = ExcelExportUtil.exportExcel(exportParams,
                    SqlXlsxBean.class,
                    sqlXlsxBeanList);
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(outputStream);
        }


    }


}
