package com.example.gittest.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 企业明细-基本信息-地理坐标信息-地理坐标信息
 * @author zhulei
 * @date 2020-12-04 14:47:44
 */
@Data
@ApiModel("o_dp_dlzbxx_dlzbxx")
@TableName("o_dp_dlzbxx_dlzbxx")
public class ODpDlzbxxDlzbxx {


    @TableId(value = "id" , type = IdType.AUTO)
    @ApiModelProperty(name="id" , value = "主键ID")
    private Integer id;


    @TableField("social_credit_code")
    @ApiModelProperty(name="socialCreditCode" , value = "社会统一信用代码")
    private String socialCreditCode;


    @TableField("entgeocooinfo_lat")
    @ApiModelProperty(name="entgeocooinfoLat" , value = "纬度")
    private String entgeocooinfoLat;


    @TableField("entgeocooinfo_id")
    @ApiModelProperty(name="entgeocooinfoId" , value = "编号")
    private String entgeocooinfoId;


    @TableField("entgeocooinfo_lon")
    @ApiModelProperty(name="entgeocooinfoLon" , value = "经度")
    private String entgeocooinfoLon;


    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    @ApiModelProperty(name="createTime" , value = "创建时间")
    private java.util.Date createTime;


    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("updata_time")
    @ApiModelProperty(name="updataTime" , value = "修改时间")
    private java.util.Date updataTime;

}
