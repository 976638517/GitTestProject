package com.example.gittest.util;

import com.google.common.collect.Lists;
import org.thymeleaf.util.ListUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WeekReportUtil {
    public static Map readText(String textPath){
        File file = new File(textPath);
        BufferedReader reader = null;
        List<String> list= Lists.newLinkedList();

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                list.add(tempStr);
            }

            reader.close();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }

}
