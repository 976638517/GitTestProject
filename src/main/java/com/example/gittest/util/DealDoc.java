package com.example.gittest.util;

import com.example.gittest.bean.DataYuan;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;


public class DealDoc {

    public static void main(String[] args) {
        //doc文档路径
        String filePath = "C:\\Users\\july\\Desktop\\data.doc";
        //test.print(filePath,"第一个表");
        System.out.println(filePath);
        for (DataYuan dataYuan:read(filePath)){
            System.out.println(dataYuan.getZwmc()+dataYuan.getMysqlDataType());
        }
    }

    /**
     * 读取文档中表格
     * @param filePath doc路径
     */
    public static List<DataYuan> read(String filePath) {

        List<DataYuan> list=new LinkedList();

        try (FileInputStream in = new FileInputStream(filePath); // 载入文档
             POIFSFileSystem pfs = new POIFSFileSystem(in);
             HWPFDocument hwpf = new HWPFDocument(pfs);) {

            Range range = hwpf.getRange();// 得到文档的读取范围
            TableIterator it = new TableIterator(range);
            // 迭代文档中的表格

            while (it.hasNext()) {
                Table tb = (Table) it.next();
                DataYuan dataYuan=new DataYuan();
                // 迭代行，默认从0开始,可以依据需要设置i的值,改变起始行数，也可设置读取到那行，只需修改循环的判断条件即可
                for (int i = 0; i < tb.numRows(); i++) {
                    TableRow tr = tb.getRow(i);
                    // 迭代列，默认从0开始
                        TableCell td = tr.getCell(0);// 取得单元格
                        // 取得单元格的内容
                        for (int k = 0; k < td.numParagraphs(); k++) {
                            Paragraph para = td.getParagraph(k);
                            String s = para.text();
                            // 去除后面的特殊符号
                            if (null != s && !"".equals(s)) {
                                s = s.substring(0, s.length() - 1);
                            }
                            s=s.trim();
                            if (s.equals("中文名称：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setZwmc(s2);
                            }

                            if (s.equals("内部标识符：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setNbbsf(s2);
                            }

                            if (s.equals("字段名：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setZidm(s2);
                            }

                            if (s.equals("定义：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setDy(s2);
                            }

                            if (s.equals("同义名称：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setTymc(s2);
                            }

                            if (s.equals("数据类型：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setSjlx(s2);
                                if (s2.contains("字符")){
                                    dataYuan.setMysqlDataType("varchar");
                                }
                                if (s2.contains("数字")){
                                    dataYuan.setMysqlDataType("int");
                                }
                                if (s2.equals("日期型")){
                                    dataYuan.setMysqlDataType("date");
                                }
                                if (s2.equals("日期时间型")){
                                    dataYuan.setMysqlDataType("datetime");
                                }
                                if (s2.equals("图片型")){
                                    dataYuan.setMysqlDataType("varchar");
                                }
                            }

                            if (s.equals("数据格式：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setSjgs(s2);
                                if (dataYuan.getSjlx().contains("数字")){
                                    if (s2.contains(",")){
                                        dataYuan.setMysqlDataType("decimal");
                                    }
                                }
                            }

                            if (s.equals("计量单位：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setJldw(s2);
                            }

                            if (s.equals("值域：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setZy(s2);
                            }

                            if (s.equals("引用关系：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setYygx(s2);
                            }

                            if (s.equals("有效性判断规则：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setYxxpdgz(s2);
                            }

                            if (s.equals("是否公示：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setSfgs(s2);
                            }

                            if (s.equals("数据产生方式：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setSjcsfs(s2);
                            }

                            if (s.equals("备注：")){
                                TableCell td2 = tr.getCell(1);
                                Paragraph para2 = td2.getParagraph(k);
                                String s2 = para2.text();
                                // 去除后面的特殊符号
                                if (null != s2 && !"".equals(s2)) {
                                    s2 = s2.substring(0, s2.length() - 1);
                                }
                                s2=s2.trim();
                                dataYuan.setBz(s2);
                            }

                        }
                }
                list.add(dataYuan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
