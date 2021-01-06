package com.example.gittest.util;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.gittest.pojo.DataTableInfo;
import com.example.gittest.pojo.SqlTable;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class InsertDataUtil {

    public static void main(String[] args) throws IOException {
        InsertDataUtil.excelToSql("C:\\Users\\july\\Desktop\\dpInfo\\jsonall\\20201218\\","各接口appkey(4)",
                "insert_access_source_detail",
                "27",
                "2020-01-05 11:00:00");
    }
    public static List<DataTableInfo> excelIN(String url) {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        params.setSheetNum(6);
        List<DataTableInfo> list = ExcelImportUtil.importExcel(
                new File(url),
                DataTableInfo.class, params);
        System.out.println(list.size());
        System.out.println(url);
        return list;
    }

    public static void excelToSql(String url,String excelname,String sqlname,String sourceId, String DATETIME) throws IOException {
        List<DataTableInfo> list = InsertDataUtil.excelIN(url+excelname+".xlsx");
        StringBuffer sb=new StringBuffer();
        for (DataTableInfo info :
                list) {
            String onesql="";
            if (info.getName().equals("企业点数据")){
                 onesql=InsertDataUtil.insertSql(info,"http://10.148.23.249:9093/enterprise/info",sourceId,DATETIME);
            }else if(info.getName().equals("企业清单")){
                continue;
            }else {
                onesql=InsertDataUtil.insertSql(info,"http://10.148.23.249:9093/enterprise/detail",sourceId,DATETIME);
            }
            sb.append(onesql);
        }
        File file = new File(url + sqlname + ".sql");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileUtil.writeAsString(file, sb.toString());
    }

    public static String insertSql(DataTableInfo dataTableInfo, String jkdz, String sourceId, String DATETIME) {
        String onesql = StringUtil.insert_access_source_detail;
        onesql = onesql.replace("SOURCE", sourceId);
        onesql = onesql.replace("NAME", dataTableInfo.getName());
        onesql = onesql.replace("URL", jkdz);
        onesql = onesql.replace("DATETIME", DATETIME);
        onesql = onesql.replace("KEY", dataTableInfo.getAppkey());
        onesql = onesql.replace("APPID", dataTableInfo.getAppid());
        return onesql;
    }
}
