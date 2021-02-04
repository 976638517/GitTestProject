package com.example.gittest.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

@Data
@ExcelTarget("ZiDuanBean")
public class ZiDuanBean   implements Serializable {
    @Excel(name = "表名")
    private String bm;
    @Excel(name = "字段中文名称")
    private String zdzwmc;
    @Excel(name = "对应英文名称")
    private String zdywmc;
    @Excel(name = "字段类型")
    private String zdlx;
    @Excel(name = "数据样例")
    private String sjyl;
    @Excel(name = "备注")
    private String bz;
}
