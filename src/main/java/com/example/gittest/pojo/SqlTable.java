package com.example.gittest.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

@Data
@ExcelTarget("SqlTable")
public class SqlTable implements Serializable {
    @Excel(name = "name")
    private String name;
    @Excel(name = "type")
    private String type;
    @Excel(name = "value")
    private String value;

}
