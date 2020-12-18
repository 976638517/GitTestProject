package com.example.gittest.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

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
