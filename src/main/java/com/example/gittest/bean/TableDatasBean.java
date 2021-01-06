package com.example.gittest.bean;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class TableDatasBean {
    /**
     * object_id : 440309
     * object_name : 龙华区
     * unit : %
     * value : -3.84984429
     * zbfm_name : 累计同比
     * zbzm_name : 规模以上工业增加值
     */

    private String object_id;
    private String object_name;
    private String unit;
    private String value;
    private String zbfm_name;
    private String zbzm_name;
}
