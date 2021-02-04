package com.example.gittest.util;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.example.gittest.pojo.SqlTable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class excelIOUtil {
    public static List<SqlTable> excelIN(String url) {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        List<SqlTable> list = ExcelImportUtil.importExcel(
                new File(url),
                SqlTable.class, params);
        System.out.println(list.size());
        System.out.println(url);
        return list;
    }


    public static void test(String name,String comment ) throws IOException {
        String url="C:\\Users\\july\\Desktop\\wenhai\\sql\\";
        List<SqlTable>list=excelIOUtil.excelIN("C:\\Users\\july\\Desktop\\wenhai\\"+name+".xls");
        String sql=JsonTxtCreateSql.sqltableTosql(list,name,comment);
        File file=new File(url+name+".sql");
        if (!file.exists()){
            file.createNewFile();
        }
        FileUtil.writeAsString(file,sql);
    }

    public static void main(String[] args) throws IOException {
        excelIOUtil.test("website","根据站点名称、发布时间等参数获取网站信息");
        excelIOUtil.test("weibo","根据关键词、weibo_id、weibo_name、时间排序等获取微博文章");
        excelIOUtil.test("douyin","根据video_id、video_name、发布时间等参数获取短视频文章");
        excelIOUtil.test("kuaishou","根据video_id、video_name、发布时间等参数获取快手文章");
        excelIOUtil.test("wechat","根据微信公众号、发布时间等参数获取微信文章");
        excelIOUtil.test("newspaper","根据电子报纸名称、发布时间等获取电子报纸");
        excelIOUtil.test("app","根据客户端名称、发布时间等获取APP文章");
        excelIOUtil.test("twitter","根据tw账号、发布时间等参数获取twitter文章");
        excelIOUtil.test("facebook","根据facebook账号、发布时间等参数获取facebook文章");
        excelIOUtil.test("translation","根据站点名称、发布时间等参数获取信息");
    }
}
