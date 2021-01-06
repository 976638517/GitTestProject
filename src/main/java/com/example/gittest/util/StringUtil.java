package com.example.gittest.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    public static String insert_access_source_detail="INSERT INTO `access_source_detail` (\n" +
            "\t`sjy_id`,\n" +
            "\t`sjmc`,\n" +
            "\t`jkdz`,\n" +
            "\t`my`,\n" +
            "\t`jk_id`,\n" +
            "\t`jklx`,\n" +
            "\t`fwyh`,\n" +
            "\t`by2`,\n" +
            "\t`by1`,\n" +
            "\t`cjsj`,\n" +
            "\t`cjr`,\n" +
            "\t`xgr`,\n" +
            "\t`xgsj`,\n" +
            "\t`by0`,\n" +
            "\t`yxzt`,\n" +
            "\t`sjly_jrlx`,\n" +
            "\t`sjly_yhm`,\n" +
            "\t`sjly_ljdz`,\n" +
            "\t`sjly_sjkmm` \n" +
            ")\n" +
            "VALUES\n" +
            "\t(\n" +
            "\t\tSOURCE,\n" +
            "\t\t'NAME',\n" +
            "\t\t'URL',\n" +
            "\t\t'KEY',\n" +
            "\t\t'APPID',\n" +
            "\t\t'http',\n" +
            "\t\tNULL,\n" +
            "\t\tNULL,\n" +
            "\t\tNULL,\n" +
            "\t\t'DATETIME',\n" +
            "\t\t'kbuser',\n" +
            "\t\t'kbuser',\n" +
            "\t\t'DATETIME',\n" +
            "\t\tNULL,\n" +
            "\t\t'true',\n" +
            "\t\t'1',\n" +
            "\t\tNULL,\n" +
            "\t\tNULL,\n" +
            "\t\tNULL \n" +
            "\t);";

    public static void main(String[] args) {
        long aaa=528620520585950527l;
        for (int i=0;i<75;i++){
            System.out.print(aaa+i);
            System.out.print(",");
        }
    }
    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }


    public static String trimToNull(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        return str.trim();
    }

    public static String encryptPhoneNum(String phoneNum) {
        if (StringUtils.isBlank(phoneNum)) {
            return phoneNum;
        }
        return phoneNum.substring(0, 3) + "****";
    }

    public static String encryptCardNum(String carNum) {
        if (StringUtils.isBlank(carNum)) {
            return carNum;
        }
        return carNum.substring(0, 3) + "**********";
    }


}
