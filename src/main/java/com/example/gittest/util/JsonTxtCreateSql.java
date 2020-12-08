package com.example.gittest.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.gittest.bean.DpRequestCellVo;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonTxtCreateSql {

    public static void main(String[] args) {
        String path = "C:\\Users\\july\\Desktop\\dpInfo\\diptxt";		//要遍历的路径
        File file = new File(path);		//获取其file对象
        func(file);
    }

    public static void func(File file){
        File[] fs = file.listFiles();
        for(File f:fs){
            if(f.isDirectory())	//若是目录，则递归打印该目录下的文件
                func(f);
            if(f.isFile())		//若是文件，直接打印
                JsonTxtCreateSql.getJson(f);
        }
    }

    public static void getJson(File file){
        try {
            String json= FileUtil.readAsString(file);
            JSONObject jsonObject = JSONObject.parseObject(json);
            JSONObject data = jsonObject.getJSONObject("data");
            if (ObjectUtils.isNotEmpty(data)) {
                JSONArray records = data.getJSONArray("records");
                for (int i = 0; i < records.size(); i++) {
                    JSONObject element = records.getJSONObject(i);
                    String txtname=file.getName();
                    JsonTxtCreateSql.jsonToSql(element,txtname.substring(0,txtname.indexOf(".")));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * CREATE TABLE `o_dp_ent_list` (
     *   `entfjbcreditcode` varchar(255) NOT NULL COMMENT '社会统一信用代码',
     *   `entunino` varchar(255) DEFAULT NULL,
     *   `entszregcapital` varchar(255) DEFAULT NULL COMMENT '注册资金',
     *   `entname` varchar(255) DEFAULT NULL,
     *   `entszentstatus` varchar(255) DEFAULT NULL COMMENT '机构状态',
     *   `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     *   `updata_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
     *   PRIMARY KEY (`entfjbcreditcode`) USING BTREE
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
     */





    public static StringBuilder jsonToSql(JSONObject jsonObject,String txtname){
        String type="` varchar(500) DEFAULT NULL COMMENT '";
        StringBuilder sb = new StringBuilder();
        JSONArray ccc = jsonObject.getJSONArray("cells");
        List<DpRequestCellVo> cells = jsonObject.getJSONArray("cells").toJavaList(DpRequestCellVo.class);



        sb.append("CREATE TABLE `o_dp_` (");
        sb.append("`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',");
        for (DpRequestCellVo dpRequestCellVo:
        cells) {
            sb.append("`");
            sb.append(dpRequestCellVo.getNcode());
            sb.append(type);
            sb.append(dpRequestCellVo.getName());
            sb.append("',");
        }
        sb.append("  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
                "  `updata_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',\n" +
                "  PRIMARY KEY (`xxxxxxx`) USING BTREE\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='");
        sb.append(txtname);
        sb.append("';");
        System.out.println(sb);
        return sb;
    }


}
