package com.example.gittest.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.gittest.bean.StatisticsDepartmentJsonDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.util.FileUtil;
import org.springframework.http.HttpMethod;

import java.io.File;
import java.io.IOException;

public class UnicodeUtil {
    public static void main(String[] args) {
        String jaon="[\n" +
                "    {\n" +
                "        \"returnparam\":\"\",\n" +
                "        \"type\":\"\",\n" +
                "        \"describe\":\"\",\n" +
                "        \"id\":\"\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"returnparam\":\"\",\n" +
                "        \"type\":\"\",\n" +
                "        \"describe\":\"\",\n" +
                "        \"value\":[\n" +
                "            {\n" +
                "                \"returnparam\":\"\",\n" +
                "                \"type\":\"\",\n" +
                "                \"describe\":\"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"returnparam\":\"\",\n" +
                "                \"type\":\"\",\n" +
                "                \"describe\":\"\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"id\":\"\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"returnparam\":\"\",\n" +
                "        \"type\":\"\",\n" +
                "        \"describe\":\"\",\n" +
                "        \"id\":\"\"\n" +
                "    }\n" +

                "]";
        String str="[{\"returnparam\":\"code\",\"type\":\"String\",\"describe\":\"处理结果code\",\"id\":\"16106952384790724\"},{\"returnparam\":\"data\",\"type\":\"Array\",\"describe\":\"处理结果数据信息\",\"value\":[{\"returnparam\":\"dataCount\",\"type\":\"integer\",\"describe\":\"数据条数\"},{\"returnparam\":\"dataSource\",\"type\":\"String\",\"describe\":\"数据来源\"}],\"id\":\"16106952384791907\"},{\"returnparam\":\"mesg\",\"type\":\"String\",\"describe\":\"处理结果描述信息\",\"id\":\"16106952384792103\"},{\"returnparam\":\"time\",\"type\":\"String\",\"describe\":\"请求结果生成时间戳\",\"id\":\"16106952384793172\"}]";
        JSONArray js= JSON.parseArray(str);
        JSONArray jsonObject= JSON.parseArray(jaon);
        jsonObject=js;
        System.out.println(jsonObject);
    }


    /**
     * 字符串编码成Unicode编码
     */
    public static String encode(String src) throws Exception {
        char c;
        StringBuilder str = new StringBuilder();
        int intAsc;
        String strHex;
        for (int i = 0; i < src.length(); i++) {
            c = src.charAt(i);
            intAsc = (int) c;
            strHex = Integer.toHexString(intAsc);
            if (intAsc > 128)
                str.append("\\u" + strHex);
            else
                str.append("\\u00" + strHex); // 低位在前面补00
        }
        return str.toString();
    }

    /**
     * Unicode解码成字符串
     * @param src
     * @return
     */
    public static String decode(String src) {
        int t =  src.length() / 6;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = src.substring(i * 6, (i + 1) * 6); // 每6位描述一个字节
            // 高位需要补上00再转
            String s1 = s.substring(2, 4) + "00";
            // 低位直接转
            String s2 = s.substring(4);
            // 将16进制的string转为int
            int n = Integer.valueOf(s1, 16) + Integer.valueOf(s2, 16);
            // 将int转换为字符
            char[] chars = Character.toChars(n);
            str.append(new String(chars));
        }
        return str.toString();
    }
    /**
     * 将Unicode编码转为字符串
     * @param unicode
     * @return
     */
    public static String decodeUnicode(String unicode){
        if (!unicode.contains("\\u")){
            return unicode;
        }
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            string.append((char) data);
        }
        return string.toString();
    }
}
