package com.example.gittest.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
public class SheetDatasBean {
    /**
     * table_datas : [{"object_id":"440309","object_name":"龙华区","unit":"%","value":"-3.84984429","zbfm_name":"累计同比","zbzm_name":"规模以上工业增加值"},{"object_id":"440309","object_name":"龙华区","unit":"亿元","value":"240.2705","zbfm_name":"累计数","zbzm_name":"社会消费品零售总额"},{"object_id":"440309","object_name":"龙华区","unit":"%","value":"6.5","zbfm_name":"累计同比","zbzm_name":"社会消费品零售总额"},{"object_id":"440309","object_name":"龙华区","unit":"%","value":"16.2","zbfm_name":"累计同比","zbzm_name":"固定资产投资完成额"},{"object_id":"440309","object_name":"龙华区","unit":"亿元","value":"118.9184","zbfm_name":"累计数","zbzm_name":"一般公共预算收入"},{"object_id":"440309","object_name":"龙华区","unit":"%","value":"3.29915462","zbfm_name":"累计同比","zbzm_name":"一般公共预算收入"},{"object_id":"440309","object_name":"龙华区","unit":"亿美元","value":"0.6461","zbfm_name":"累计数","zbzm_name":"外商直接投资"},{"object_id":"440309","object_name":"龙华区","unit":"%","value":"-84.6","zbfm_name":"累计同比","zbzm_name":"外商直接投资"},{"object_id":"440309","object_name":"龙华区","unit":"亿元","value":"3423.761","zbfm_name":"累计数","zbzm_name":"进出口总额"},{"object_id":"440309","object_name":"龙华区","unit":"%","value":"-17.73672256","zbfm_name":"累计同比","zbzm_name":"进出口总额"},{"object_id":"440309","object_name":"龙华区","unit":"亿元","value":"1398.7006","zbfm_name":"累计数","zbzm_name":"进出口总额#进口总额"},{"object_id":"440309","object_name":"龙华区","unit":"%","value":"-27.57290954","zbfm_name":"累计同比","zbzm_name":"进出口总额#进口总额"},{"object_id":"440309","object_name":"龙华区","unit":"亿元","value":"2025.0604","zbfm_name":"累计数","zbzm_name":"进出口总额#出口总额"},{"object_id":"440309","object_name":"龙华区","unit":"%","value":"-9.22151048","zbfm_name":"累计同比","zbzm_name":"进出口总额#出口总额"},{"object_id":"440309","object_name":"龙华区","unit":"亿元","value":"375.12","zbfm_name":"累计数","zbzm_name":"税收收入"},{"object_id":"440309","object_name":"龙华区","unit":"%","value":"3.2","zbfm_name":"累计同比","zbzm_name":"税收收入"}]
     * table_name : 龙华区主要经济指标
     */

    private String table_name;
    private List<TableDatasBean> table_datas;
}
