package com.example.gittest.util;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.gittest.pojo.AAAA;
import com.example.gittest.pojo.ImportDataResponseField;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.util.FileUtil;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class test {
    static public String cs1 = "[{\"parameters\":\"endTime\",\"type\":\"String\",\"ismust\":\"false\",\"describe\":\"查询小于等于结束时间\",\"example\":\"2020-12-01 00:00:00\"},{\"parameters\":\"pageIndex\",\"type\":\"Integer\",\"ismust\":\"false\",\"describe\":\"分页查询当前页码，最小为1\",\"example\":\"1\"},{\"parameters\":\"pageSize\",\"type\":\"Integer\",\"ismust\":\"false\",\"describe\":\"分页查询每页页数,最小为1\",\"example\":\"1\"},{\"parameters\":\"socialCreditCode\",\"type\":\"String\",\"ismust\":\"false\",\"describe\":\"企业社会统一信用代码，可以为空\",\"example\":\"\"},{\"parameters\":\"startTime\",\"type\":\"String\",\"ismust\":\"false\",\"describe\":\"查询大于开始时间 \",\"example\":\"2000-01-01 00:00:00\"}]";
    static public String cs2 = "";

    static public String sqll = "INSERT INTO `api_service` ( `api_id`, `api_title`, `api_description`, `api_url`, `business_parameters`, `special_version`, `request_method`, ` error_code`, `return_format`, `return_parameter`, `tid`, `api_provider` )\n" +
            "VALUES\n" +
            "\t( '##', '@@', 'ms', 'url', '**', NULL, 'Post', '[{\\\"errorcode\\\":\\\"201\\\",\\\"message\\\":\\\"Created\\\"},{\\\"errorcode\\\":\\\"401\\\",\\\"message\\\":\\\"Unauthorized\\\"},{\\\"errorcode\\\":\\\"403\\\",\\\"message\\\":\\\"Forbidden\\\"},{\\\"errorcode\\\":\\\"404\\\",\\\"message\\\":\\\"Not Found\\\"}]', 'JSON', '!!', 2, ' 华傲' );";
    static public String str1 = "[{\n" +
            "\t\"returnparam\": \"code\",\n" +
            "\t\"type\": \"Integer\",\n" +
            "\t\"describe\": \"返回结果码,1-成功0-失败\"\n" +
            "}, {\n" +
            "\t\"returnparam\": \"data\",\n" +
            "\t\"type\": \"Array\",\n" +
            "\t\"describe\": \"返回结果主体数据\",\n" +
            "\t\"value\": [{\n" +
            "\t\t\"returnparam\": \"current\",\n" +
            "\t\t\"type\": \"Integer\",\n" +
            "\t\t\"describe\": \"\"\n" +
            "\t}, {\n" +
            "\t\t\"returnparam\": \"hitCount\",\n" +
            "\t\t\"type\": \"boolean\",\n" +
            "\t\t\"describe\": \"\"\n" +
            "\t}, {\n" +
            "\t\t\"returnparam\": \"pages\",\n" +
            "\t\t\"type\": \"Integer\",\n" +
            "\t\t\"describe\": \"\"\n" +
            "\t}, {\n" +
            "\t\t\"returnparam\": \"records\",\n" +
            "\t\t\"type\": \"Array\",\n" +
            "\t\t\"describe\": \"\",\n" +
            "\t\t\"value\": ";

    static public String str2 = "\t}]\n" +
            "}, {\n" +
            "\t\"returnparam\": \"msg\",\n" +
            "\t\"type\": \"String\",\n" +
            "\t\"describe\": \"返回结果信息\"\n" +
            "}]";
    static public String str3 = "[{\n" +
            "\t\"returnparam\": \"code\",\n" +
            "\t\"type\": \"Integer\",\n" +
            "\t\"describe\": \"返回结果码,1-成功0-失败\"\n" +
            "}, {\n" +
            "\t\"returnparam\": \"data\",\n" +
            "\t\"type\": \"Array\",\n" +
            "\t\"describe\": \"返回结果主体数据\",\n" +
            "\t\"value\": ";
    static public String str4 = "}, {\n" +
            "\t\"returnparam\": \"msg\",\n" +
            "\t\"type\": \"String\",\n" +
            "\t\"describe\": \"返回结果信息\"\n" +
            "}]";


    public static String deal(File file) {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        List<AAAA> list = ExcelImportUtil.importExcel(
                file,
                AAAA.class, params);
        List<AAAA> list2 = Lists.newArrayList();
        for (AAAA aaaa :
                list) {
            if (!ObjectUtils.isEmpty(aaaa.getReturnparam())) {
                list2.add(aaaa);
            }
        }
        String json = JSONObject.toJSONString(list2);
        return json;
    }

    public static void mainr(String[] args) throws IOException {
        File file = new File("C:\\Users\\july\\Desktop\\接口api");
        File[] ary = file.listFiles();
        StringBuffer sb = new StringBuffer();

        int i = 2;
        for (File file1 :
                ary) {
            i = i + 1;
            String name = file1.getName();
            name = name.substring(0, name.indexOf("."));

            String json = test.deal(file1);
            JSONArray jsonObject = null;
            if (name.startsWith("1")) {
                json = str3 + json;
                json = json + str4;
            } else {
                json = str1 + json;
                json = json + str2;
            }
            try {
                jsonObject = JSONArray.parseArray(json);
            } catch (Exception e) {
                System.out.println("##########" + name);
                System.out.println("##########" + json);
                continue;
            }
            System.out.println(json);
            String qqq = sqll;
            qqq = qqq.replace("##", i + "");
            qqq = qqq.replace("@@", name);
            qqq = qqq.replace("!!", json);
            qqq = qqq.replace("**", cs1);
            sb.append(qqq);
        }

        File file2 = new File("C:\\Users\\july\\Desktop\\接口api\\" + "insert.sql");
        if (!file2.exists())
            file2.createNewFile();
        System.out.println(sb);
        FileUtil.writeAsString(file2, sb.toString());
    }


    public static final String str = "{\"code\":\"200\", \"data\":{\"total\":\"1\",\"current\":\"1\",\"records\":[ {\"cells\":[ {\"ncode\":\"entgeocooinfo_lat\",\"name\":\"纬度\", \"value\":\"23132\"},{ \"ncode\":\"entgeocooinfo_id\",\"name\":\"编号\",\"value\":\"32132\"}, {\"ncode\":\"entgeocooinfo_lon\",\"name\":\"经度\", \"value\":\"21321\" }]}, {\"cells\":[ {\"ncode\":\"entgeocooinfo_lat\",\"name\":\"纬度\", \"value\":\"112\" },{\"ncode\":\"entgeocooinfo_id\",\"name\":\"编号\",\"value\":\"1111\" },{\"ncode\":\"entgeocooinfo_lon\",\"name\":\"经度\",\"value\":\"23123\" }] }], \"pageSize\":\"10\"},\"message\":\"查询成功\",\"timestamp\":\"1548831552076\"}";
    public static final String json_object_start = "{";
    public static final String json_object_end = "}";
    public static final String json_array_start = "[";
    public static final String json_array_end = "]";

    public static void parseJson(String str, List<ImportDataResponseField> list,Integer parentId) {
        if (str.startsWith(json_object_start) && str.endsWith(json_object_end)) {
            JSONObject jsonObject = JSONObject.parseObject(str);
            for (Map.Entry<String, Object> entry :
                    jsonObject.entrySet()) {
                ImportDataResponseField field = new ImportDataResponseField();
                field.setFieldName(entry.getKey());
                field.setJsonValue(entry.getValue());
                list.add(field);
            }
        }
        if (str.startsWith(json_array_start) && str.endsWith(json_array_end)) {
            JSONArray jsonArray = JSONArray.parseArray(str);
            String json = JSON.toJSONString(jsonArray.get(0));
            parseJson(json, list,parentId);
        }
    }

    public static void main(String[] args) {
        String reportDate="201912";
        LocalDate localDateTime=LocalDate.of(
                Integer.parseInt(reportDate.substring(0,4)),
                Integer.parseInt(reportDate.substring(4,reportDate.length())),
                1);
        localDateTime=localDateTime.plusMonths(1);
        String str=localDateTime.format(DateTimeFormatter.ofPattern("yyyyMM"));
        System.out.println(str);
    }
}
