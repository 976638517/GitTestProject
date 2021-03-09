package com.example.gittest.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Exceltable    {

    private String zd;

    private String zs;

    private List<ExcelFild> filds;

}
