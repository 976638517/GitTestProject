package com.example.gittest.util;


import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {


    public final static String PATTERN_1 = "yyyy-MM-dd HH:mm:ss";
    public final static String PATTERN_2 = "yyyy-MM-dd";
    public final static String PATTERN_3 = "yyyyMMddHHmmss";
    public final static String PATTERN_4 = "yyyy/M/d H:m:s";
    public final static String PATTERN_5 = "yyyyMMdd";

//    public static String getWeekDuringByNowTime() {
//        https://blog.csdn.net/xcc_2269861428/article/details/81298344?utm_source=blogxgwz1
//        // 获得本周一与当前日期相差的天数
//        public static int getMondayPlus () {
//            Calendar cd = Calendar.getInstance();
//            int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
//            //由于Calendar提供的都是以星期日作为周一的开始时间
//            if (dayOfWeek == 1) {
//                return -6;
//            } else {
//                return 2 - dayOfWeek;
//            }
//
//        }

        public static String format (Date date, String pattern){
            if (date == null || StringUtils.isBlank(pattern)) {
                return null;
            }
            DateFormat df = null;
            try {
                df = new SimpleDateFormat(pattern);
                return df.format(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


        public static Date parse (String dateStr, String pattern){
            if (StringUtils.isBlank(dateStr) || StringUtils.isBlank(pattern)) {
                return null;
            }
            DateFormat df;
            try {
                df = new SimpleDateFormat(pattern);
                return df.parse(dateStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public static Date parseByPattern1 (String dateStr){
            return parse(dateStr, PATTERN_1);
        }

        public static Date parseByPattern2 (String dateStr){
            return parse(dateStr, PATTERN_2);
        }

        public static String formatByPattern2 (Date date){
            return format(date, PATTERN_2);
        }

        public static Date parseByPattern4 (String dateStr){
            return parse(dateStr, PATTERN_4);
        }

        public static String formatByPattern1 (Date date){
            return format(date, PATTERN_1);
        }
        public static String formatByPattern3 (Date date){
            return format(date, PATTERN_3);
        }

        public static Date adjustDate (Date date,long mills){
            long time = date.getTime();
            Date newDate = new Date();
            newDate.setTime(time + mills);
            return newDate;
        }

        public static Date curDate () {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            return calendar.getTime();
        }

        public static Date startOfNextDay (Date date){
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
            return calendar.getTime();
        }

        public static Date startTimeOfLastMonth (Date date){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            return calendar.getTime();
        }

        public static Date startDayOfMonth (Date date){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            return calendar.getTime();
        }


        public static Date startDayOfNextMonth (Date date){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
            return calendar.getTime();
        }


        public static Date endTimeOfMonth (Date date){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
            return calendar.getTime();
        }

        public static int compareByPattern1 (String a, String b){
            return compare(parseByPattern1(a), parseByPattern1(b));
        }

        public static int compare (Date a, Date b){
            if (a == null || b == null) {
                return 0;
            }
            return a.compareTo(b);
        }

    }
