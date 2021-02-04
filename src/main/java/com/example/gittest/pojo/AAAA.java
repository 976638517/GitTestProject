package com.example.gittest.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

@Data
@ExcelTarget("AAAA")
public class AAAA  implements Serializable {
    @Excel(name = "returnparam")
    private String returnparam;
    @Excel(name = "describe")
    private String describe;
    @Excel(name = "type")
    private String type;
}

