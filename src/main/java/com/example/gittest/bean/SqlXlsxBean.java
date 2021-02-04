package com.example.gittest.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.example.gittest.util.ChineseCharToEnUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

import java.io.Serializable;

@Data
@ExcelTarget("SqlXlsxBean")
public class SqlXlsxBean   implements Serializable {

    @Excel(name = "id" ,fixedIndex=0)
    private String id;
    @Excel(name = "field",fixedIndex=1)
    private String field;
    @Excel(name = "type",fixedIndex=2)
    private String type;
    @Excel(name = "fieldJson",fixedIndex=3)
    private String fieldJson;
    @Excel(name = "tableName",fixedIndex=4)
    private String tableName;
    @Excel(name = "tableDesc",fixedIndex=5)
    private String tableDesc;
    @Excel(name = "dbName",fixedIndex=6)
    private String dbName;
    @Excel(name = "batch",fixedIndex=7)
    private String batch;
    @Excel(name = "yTableName",fixedIndex=8)
    private String YTableName;
    @Excel(name = "yDbName",fixedIndex=9)
    private String YDbName;
    @Excel(name = "fieldCn",fixedIndex=10)
    private String fieldCn;
    @Excel(name = "dbCode",fixedIndex=11)
    private String dbCode;
    @Excel(name = "inrField",fixedIndex=12)
    private String inrField;


    public SqlXlsxBean(){};

    public SqlXlsxBean(String id,ZiDuanBean zbean,TbaleXlsxBean tbean){
        ChineseCharToEnUtil cte = new ChineseCharToEnUtil();
        this.id = id;
        this.field = cte.getAllFirstLetter(zbean.getZdzwmc());
        String jdbcType="VARCHAR";
        if (StringUtils.equals(zbean.getZdlx(),"float")){
            jdbcType="DOUBLE";
        }
        if (StringUtils.equals(zbean.getZdlx(),"dict")){
            jdbcType="TEXT";
        }
        if (StringUtils.equals(zbean.getZdlx(),"list of dict")){
            jdbcType="TEXT";
        }
        if (StringUtils.equals(zbean.getZdlx(),"int")){
            jdbcType="INT";
        }
        this.type = jdbcType;
        this.fieldJson = zbean.getZdywmc();
        this.tableName = "c_tj_"+tbean.getYwbm();
        this.tableDesc = "天眼查"+tbean.getZwbm()+"数据";
        this.dbName = "data_center";
        this.batch = "2";
        this.YTableName = "o_tj_"+tbean.getYwbm();
        this.YDbName = "dw_ent";
        this.fieldCn = zbean.getZdzwmc();
        this.dbCode = "t"+tbean.getId();
        this.inrField = "id";
    }
}
