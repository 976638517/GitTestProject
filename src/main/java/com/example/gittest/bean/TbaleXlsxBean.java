package com.example.gittest.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

@Data
@ExcelTarget("TbaleXlsxBean")
public class TbaleXlsxBean   implements Serializable {
    @Excel(name = "id")
    private String id;
    @Excel(name = "中文表名")
    private String zwbm;
    @Excel(name = "英文表名")
    private String ywbm;
    @Excel(name = "索引字段")
    private String syzd;
}
