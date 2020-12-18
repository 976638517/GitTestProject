package com.example.gittest.util;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.util.FileUtil;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class dealclasss {
    static String schstr = "@Scheduled(fixedDelay = 2 * 24 * 60 * 60 * 1000)";
    static String methedStr = "public void dpSyncPart24() {";
    static String endStr = "}";
    static String str1 = "List<String> errorList? = dpEntDataSync.dpEntSync(###.class, ###ServiceImpl.class, ###.appid, ###.appkey);";
    static String str2 = "dpEntDataSync.recurrenceDealerrorlist(errorList?, ###.class, ###ServiceImpl.class, ###.appid, ###.appkey);";

    public static void main(String[] args) throws IOException {
        String[] strAry = WeekReportUtil.readText("C:\\Users\\july\\Desktop\\dpInfo\\20201217\\sql.txt", "CREATE TABLE `");
        dealclasss.getClassNameUtil(strAry);
    }

    public static void getClassNameUtil(String[] strAry) {
        StringBuffer sb = new StringBuffer();
        int x=1;
        for (String str :
                strAry) {
            if (StringUtils.isBlank(str)){
                continue;
            }
            if (x==4){
                x=1;
            }
            int index = str.indexOf("`");
            String node = str.substring(0,index);
            String key = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, node);
            String str11 = str1.replace("###", key);
            str11 =str11.replace("?",x+"");
            String str22 = str2.replace("###", key);
            str22 =str22.replace("?",x+"");
            sb.append("\n");
            sb.append(str11);
            sb.append("\n");
            sb.append(str22);
            System.out.println(sb);
            sb.delete(0, sb.length());
            x++;
        }
    }
}
