package com.example.gittest.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

@Data
@ExcelTarget("DataTableInfo")
public class DataTableInfo implements Serializable {
    @Excel(name = "name")
    private String name;
    @Excel(name = "appid")
    private String appid;
    @Excel(name = "appkey")
    private String appkey;
}
