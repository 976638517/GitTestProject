package com.example.gittest.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class rowPojo {
    //    中文名称：	审核人
    @Excel(name = "值")
    private String str;
}
