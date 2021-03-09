package com.example.gittest.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportExcelItem;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.gittest.bean.ExcelFild;
import com.example.gittest.bean.Exceltable;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.aspectj.util.FileUtil;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class excelIOUtil {
    public static List<ExcelFild> excelIN(String url) {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        params.setHeadRows(1);
        params.setSheetNum(73);
        params.setStartSheetIndex(1);
        params.setKeyIndex(1);
        List<ExcelFild> list = ExcelImportUtil.importExcel(
                new File(url),
                ExcelFild.class, params);
        System.out.println(list.size());
        System.out.println(url);
        return list;
    }

    public static List<ExcelFild> xx(String url) {
        ImportParams params = new ImportParams();
        List<ExcelFild> list = ExcelImportUtil.importExcel(
                new File(url),
                ExcelFild.class, params);
        System.out.println(list.size());
        System.out.println(url);
        return list;
    }

    public static List<Exceltable> deal(List<ExcelFild> list) {
        List<Exceltable> exceltables = Lists.newLinkedList();
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            if (1 + i == list.size()) {
                break;
            }
            ExcelFild em1 = list.get(i);
            ExcelFild em2 = list.get(i + 1);
            if (list.get(i).getLx() == null) {
                list.get(i).setLx(list.get(i).getLx2());
            }
            if (em1.getLx() == null && em2.getLx() == null && em1.getZs() == null && em2.getZs() == null && flag < i) {
                List<ExcelFild> list1 = list.subList(flag + 3, i);
                Exceltable exceltable = new Exceltable();
                exceltable.setZd(list.get(flag).getZd());
                exceltable.setZs(list.get(flag + 1).getZd());
                exceltable.setFilds(list1);
                exceltables.add(exceltable);
                flag = i;
            }
        }
        return exceltables;
    }

    public static void main1() throws IOException {
        List<ExcelFild> name = xx("C:\\Users\\july\\Desktop\\name.xlsx");
        String dirUrl = "C:\\Users\\july\\Desktop\\aaaa.sql";
        File dir = new File(dirUrl);
        File result = new File(dirUrl);
        if (!result.exists()) {
            result.createNewFile();
        }
        StringBuffer sb = new StringBuffer();
        String sql1 = "ALTER TABLE `dw_ent`.`";
        //biaom
        String sql2 = "` COMMENT = '";
        //zs
        String sql3 = "';";

        String sql4 = "alter table `dw_ent`.`";
        //biaom
        String sql5 = "` modify column `";
        //lm
        String sql6 = "` ";
        //leix
        String sql7 = " comment '";
        //zs
        String sql8 = "';";

        List<ExcelFild> list = excelIN("C:\\Users\\july\\Desktop\\龙华区公共信用信息管理系统信用目录数据字典.xlsx");
        List<Exceltable> list1 = deal(list);
        for (Exceltable exceltable :
                list1) {
            for (ExcelFild tn :
                    name) {
                if (StringUtils.equalsIgnoreCase(tn.getComm(), "o_xy_" + exceltable.getZd())) {
                    exceltable.setZd(tn.getComm());
                }
            }
            sb.append(sql1);
            sb.append(exceltable.getZd());
            sb.append(sql2);
            sb.append(exceltable.getZs());
            sb.append(sql3);
            sb.append("\n");
            for (ExcelFild fild :
                    exceltable.getFilds()) {
                if (StringUtils.equalsAny(fild.getLx(), "float", "double", "int", "decimal")) {
                    fild.setLx("decimal(30,6)");
                }
                if (StringUtils.equalsAny(fild.getLx(), "datetime", "date", "time")) {
                    fild.setLx("datetime");
                } else {
                    fild.setLx("longtext");
                }
                sb.append(sql4);
                sb.append(exceltable.getZd());
                sb.append(sql5);
                sb.append(fild.getZd());
                sb.append(sql6);
                sb.append(fild.getLx());
                sb.append(sql7);
                sb.append(fild.getZs());
                sb.append(sql8);
                sb.append("\n");
            }
        }
        FileUtil.writeAsString(dir, sb.toString());
    }

    public static void main2(String[] args) {
        StringBuffer sb = new StringBuffer();
        String sql1 = "ALTER TABLE `dw_ent`.`";
        //biaom
        String sql2 = "` COMMENT = '";
        //zs
        String sql3 = "';";

        String sql4 = "alter table `dw_ent`.`";
        //biaom
        String sql5 = "` modify column `";
        //lm
        String sql6 = "` ";
        //leix
        String sql7 = " comment '";
        //zs
        String sql8 = "';";
        String url = "C:\\Users\\july\\Desktop\\企服.xlsx";
        ImportParams params = new ImportParams();
        List<Exceltable> exceltableList = Lists.newLinkedList();
        for (int i = 0; i < 19; i++) {
            params.setStartSheetIndex(i);
            params.setHeadRows(0);
            List<ExcelFild> list = ExcelImportUtil.importExcel(
                    new File(url),
                    ExcelFild.class, params);
            Exceltable exceltable = new Exceltable();
            exceltable.setZd(list.get(0).getComm());
            exceltable.setFilds(list.subList(2, list.size()));
            exceltableList.add(exceltable);
        }
        for (Exceltable exceltable :
                exceltableList) {
            exceltable.setZs("");
            sb.append(sql1);
            sb.append("o_qf_"+exceltable.getZd());
            sb.append(sql2);
            sb.append(exceltable.getZs());
            sb.append(sql3);
            sb.append("\n");
            for (ExcelFild fild :
                    exceltable.getFilds()) {

                if (StringUtils.equalsAny(fild.getZd(), "float", "double", "int", "decimal")) {
                    fild.setZd("decimal(30,6)");
                } else if (StringUtils.equalsAny(fild.getZd(), "datetime", "date", "time")) {
                    fild.setZd("datetime");
                } else {
                    fild.setZd("longtext");
                }

                if (fild.getComm().equals("id")){
                    fild.setZd("int(11)");
                }

                if ( StringUtils.isBlank(fild.getZs())){
                    fild.setZs("");
                }
                sb.append(sql4);
                sb.append("o_qf_"+exceltable.getZd());
                sb.append(sql5);
                sb.append(fild.getComm());
                sb.append(sql6);
                sb.append(fild.getZd());
                sb.append(sql7);
                sb.append(fild.getZs());
                sb.append(sql8);
                sb.append("\n");
            }
        }
        FileUtil.writeAsString(new File("C:\\Users\\july\\Desktop\\kkk.sql"), sb.toString());
    }

    public static void main3(String[] args) throws IOException {
        List<ExcelFild> list = excelIN("C:\\Users\\july\\Desktop\\龙华区公共信用信息管理系统信用目录数据字典.xlsx");
        List<Exceltable> list1 = deal(list);
        List<ExcelFild> name = xx("C:\\Users\\july\\Desktop\\fieldname.xlsx");
        for (Exceltable exceltable:
        list1) {
            String tbn="o_xy_"+exceltable.getZd();
            for (ExcelFild fild:
            exceltable.getFilds() ) {
                String fdn=fild.getZd();
                String a=tbn.toLowerCase()+"+"+fdn;
                Iterator<ExcelFild> iterator=name.iterator();
                while (iterator.hasNext()){
                    ExcelFild db=iterator.next();
                    String dbtn=db.getComm();
                    String dbfn=db.getZd();
                    String b=dbtn.toLowerCase()+"+"+dbfn;
                    if (a.equals(b)){
                        iterator.remove();
                    }
                }
            }
        }
        ExportParams params=new ExportParams();

        Workbook workbook=ExcelExportUtil.exportExcel(params,ExcelFild.class,name);
        FileOutputStream o=new FileOutputStream(new File("C:\\Users\\july\\Desktop\\fieldname2.xlsx"));
        workbook.write(o);
    }

    public static void main4(String[] args) {
        String sql1 = "ALTER TABLE `dw_ent`.`";
        //biaom
        String sql2 = "` COMMENT = '";
        //zs
        String sql3 = "';";
        StringBuffer sb = new StringBuffer();
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        params.setStartSheetIndex(19);
        params.setKeyIndex(1);
        List<ExcelFild> list = ExcelImportUtil.importExcel(
                new File("C:\\Users\\july\\Desktop\\企服.xlsx"),
                ExcelFild.class, params);
        for (ExcelFild excelFild:
        list ) {
            sb.append(sql1);
            sb.append(excelFild.getZd());
            sb.append(sql2);
            sb.append(excelFild.getZs());
            sb.append(sql3);
            sb.append("\n");
        }
        FileUtil.writeAsString(new File("C:\\Users\\july\\Desktop\\lll.sql"), sb.toString());
    }


    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        String sql1 = "ALTER TABLE `dw_ent`.`";
        //biaom
        String sql2 = "` COMMENT = '";
        //zs
        String sql3 = "';";

        String sql4 = "alter table `dw_ent`.`";
        //biaom
        String sql5 = "` modify column `";
        //lm
        String sql6 = "` ";
        //leix
        String sql7 = " comment '";
        //zs
        String sql8 = "';";
        String url = "C:\\Users\\july\\Desktop\\探迹交付数据字典说明文档(2)(1)(1).xlsx";
        ImportParams params = new ImportParams();
        List<Exceltable> exceltableList = Lists.newLinkedList();
        params.setStartSheetIndex(1);
        List<ExcelFild> list = ExcelImportUtil.importExcel(
                new File(url),
                ExcelFild.class, params);
        for (ExcelFild tbn:
        list) {
            if (StringUtils.isBlank(tbn.getComm())){
                continue;
            }
            Exceltable exceltable=new Exceltable();
            exceltable.setZd(tbn.getZd());
            exceltable.setZs(tbn.getComm());
            exceltable.setFilds(new LinkedList<>());
            exceltableList.add(exceltable);
        }

        params.setStartSheetIndex(0);
        List<ExcelFild> fildList = ExcelImportUtil.importExcel(
                new File(url),
                ExcelFild.class, params);

        for (ExcelFild fild:
        fildList) {
            String zwbm=fild.getComm();
            for (Exceltable exceltable:
            exceltableList) {
                if (StringUtils.equals(exceltable.getZs(),zwbm)){
                    exceltable.getFilds().add(fild);
                }
            }
        }

        for (Exceltable exceltable :
                exceltableList) {
            sb.append(sql1);
            sb.append("o_tj_"+exceltable.getZd());
            sb.append(sql2);
            sb.append(exceltable.getZs());
            sb.append(sql3);
            sb.append("\n");
            for (ExcelFild fild :
                    exceltable.getFilds()) {

                if (StringUtils.equalsAny(fild.getLx(), "float", "double", "int", "decimal")) {
                    fild.setLx("decimal(30,6)");
                } else if (StringUtils.equalsAny(fild.getLx(), "date_str","datetime_str")) {
                    fild.setLx("datetime");
                } else {
                    fild.setLx("longtext");
                }

                if ( StringUtils.isBlank(fild.getZs())){
                    fild.setZs("");
                }
                sb.append(sql4);
                sb.append("o_tj_"+exceltable.getZd());
                sb.append(sql5);
                sb.append(fild.getZs());
                sb.append(sql6);
                sb.append(fild.getLx());
                sb.append(sql7);
                sb.append(fild.getZd());
                sb.append(sql8);
                sb.append("\n");
            }
        }
        FileUtil.writeAsString(new File("C:\\Users\\july\\Desktop\\ttt.sql"), sb.toString());
    }
}
