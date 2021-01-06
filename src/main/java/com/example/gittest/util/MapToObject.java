package com.example.gittest.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.gittest.bean.DpRequestCellVo;

import com.google.common.base.CaseFormat;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.ss.formula.functions.T;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class MapToObject {

    public static  Object mapToObject(Class c, List<DpRequestCellVo> list) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Object tt =  c.newInstance();
        for (DpRequestCellVo dpRequestCellVo:
             list) {
            String node=dpRequestCellVo.getNcode();
            String value=dpRequestCellVo.getValue();
            String key=CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, node);
            Field field = tt.getClass().getDeclaredField(key);//根据属性名获取setter/getter
            field.setAccessible(true);//设置些属性是可以访问的
            field.set(tt, value);
        }
        return tt;
    }

    public  static <T> List<T> jsonToCell(JSONObject jsonObject,Class<T> c) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        JSONObject data = jsonObject.getJSONObject("data");
        if (ObjectUtils.isNotEmpty(data)) {
            List<T> list= Lists.newArrayList();
            JSONArray records = data.getJSONArray("records");
            for (int i = 0; i < records.size(); i++) {
                JSONObject element = records.getJSONObject(i);
                List<DpRequestCellVo> cells = element.getJSONArray("cells").toJavaList(DpRequestCellVo.class);
                T oDpDlzbxxDlzbxxo=(T)MapToObject.mapToObject(c,cells);
                list.add(oDpDlzbxxDlzbxxo);
                System.out.println(oDpDlzbxxDlzbxxo);
            }
            return list;
        }
        return null;
    }


    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        String str="{\n" +
                "\t\"code\": \"200\",\n" +
                "\t\"data\": {\n" +
                "\t\t\"total\": \"1\",\n" +
                "\t\t\"current\": \"1\",\n" +
                "\t\t\"records\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\"cells\": [{\n" +
                "\t\t\t\t\"ncode\": \"entgeocooinfo_lat\",\n" +
                "\t\t\t\t\"name\": \"纬度\",\n" +
                "\t\t\t\t\"value\": \"23132\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"ncode\": \"entgeocooinfo_id\",\n" +
                "\t\t\t\t\"name\": \"编号\",\n" +
                "\t\t\t\t\"value\": \"32132\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"ncode\": \"entgeocooinfo_lon\",\n" +
                "\t\t\t\t\"name\": \"经度\",\n" +
                "\t\t\t\t\"value\": \"21321\"\n" +
                "\t\t\t}]\n" +
                "\t\t\t},\n" +
                "{\n" +
                "                \"cells\":[\n" +
                "                    {\n" +
                "                        \"ncode\":\"entgeocooinfo_lat\",\n" +
                "                        \"name\":\"纬度\",\n" +
                "                        \"value\":\"112\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ncode\":\"entgeocooinfo_id\",\n" +
                "                        \"name\":\"编号\",\n" +
                "                        \"value\":\"1111\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ncode\":\"entgeocooinfo_lon\",\n" +
                "                        \"name\":\"经度\",\n" +
                "                        \"value\":\"23123\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "\n" +
                "\n" +
                "\t\t],\n" +
                "\t\t\"pageSize\": \"10\"\n" +
                "\t},\n" +
                "\t\"message\": \"查询成功\",\n" +
                "\t\"timestamp\": \"1548831552076\"\n" +
                "}\n" +
                "\n";
        List s=null;
        System.out.println(s.size());
        JSONObject jsonObject= JSON.parseObject(str);
//        List<ODpDlzbxxDlzbxx> list=MapToObject.jsonToCell(jsonObject,ODpDlzbxxDlzbxx.class);
//        System.out.println(list.addAll(Lists.newArrayList()));;

//        System.out.println(list);

        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "entgeocooinfo_lat"));//testData

        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "entgeocooinfo_lat"));//testData

        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "entgeocooinfo_lat"));//TestData



        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testdata"));//testdata

        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "TestData"));//test_data

        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "testData"));//test-data
    }

}
