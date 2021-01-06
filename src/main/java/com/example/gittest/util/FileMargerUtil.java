package com.example.gittest.util;

import com.alibaba.fastjson.JSONObject;
import com.example.gittest.bean.DpListRequest;
import com.example.gittest.bean.RecordsBean;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileMargerUtil {
    public static void main(String[] args) throws IOException {
        FileMargerUtil.txtMarger("C:\\Users\\july\\Desktop\\wenhai\\sql",FileMargerUtil.sql);
    }

    public static String txt = ".txt";
    public static String sql = ".sql";

    public static String txtMarger(String dirUrl, String endStr) throws IOException {
        File dir = new File(dirUrl);
        File result = new File(dirUrl + "\\" + "result" + endStr);
        if (!result.exists()) {
            result.createNewFile();
        }
        File[] fileAry = dir.listFiles();
        StringBuffer sb = new StringBuffer();
        int i = 1;
        for (File file :
                fileAry) {
            String filename = file.getName();
            if (filename.endsWith(".txt") || filename.endsWith(".sql")) {
                sb.append(FileUtil.readAsString(file));
                System.out.println(i++);
            }
        }
        return FileUtil.writeAsString(result, sb.toString());
    }

    public static String getJson(String url) throws IOException {
        File dir = new File(url);
        String result = "";
        String json = FileUtil.readAsString(dir);
        DpListRequest dpListRequest = JSONObject.parseObject(json, DpListRequest.class);
        List<RecordsBean> recordsBeanList = dpListRequest.getData().getRecords();
        System.out.println(recordsBeanList.size());
        for (RecordsBean recordsBean :
                recordsBeanList) {
            result = result + "\n" + "'" + recordsBean.getEntfjbcreditcode() + "',";
        }
        return result;
    }
}
