package com.example.gittest.util;

import com.google.common.collect.Lists;
import org.aspectj.util.FileUtil;
import org.thymeleaf.util.ListUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WeekReportUtil {
    public static String[] readText(String textPath,String sqlitStr) throws IOException {
        File file =new File(textPath);
        if (file.exists()&&file.isFile()){
            String json= FileUtil.readAsString(file);
            String[] strAry=json.split(sqlitStr);
            return strAry;
        }
        else {
            return null;
        }
    }

//    https://my.oschina.net/laigous/blog/315829?fromerr=U9okoQjk

}
