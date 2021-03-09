package com.example.gittest.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

@Data
@ExcelTarget("ExcelFild")
public class ExcelFild implements  Serializable  {
    @Excel(fixedIndex = 0,name = "0",needMerge = true)
    private String comm;
    @Excel(fixedIndex = 1,name = "1")
    private String zd;
    @Excel(fixedIndex = 2,name = "2")
    private String zs;
    @Excel(fixedIndex = 3,name = "3")
    private String lx;
    @Excel(fixedIndex = 4,name = "4")
    private String lx2;

}
