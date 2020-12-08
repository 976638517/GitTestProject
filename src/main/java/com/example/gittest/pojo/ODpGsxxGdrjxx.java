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
 * 企业明细-基本信息-工商信息(启信宝)-股东认缴信息
 * @author zhulei
 * @date 2020-12-04 14:47:44
 */
@Data
@ApiModel("o_dp_gsxx_gdrjxx")
@TableName("o_dp_gsxx_gdrjxx")
public class ODpGsxxGdrjxx {


    @TableId(value = "id" , type = IdType.AUTO)
    @ApiModelProperty(name="id" , value = "主键ID")
    private Integer id;


    @TableField("enttqxbssztpsci_fname")
    @ApiModelProperty(name="enttqxbssztpsciFname" , value = "企业名称")
    private String enttqxbssztpsciFname;


    @TableField("enttqxbssztpsci_fcreditno")
    @ApiModelProperty(name="enttqxbssztpsciFcreditno" , value = "统一社会信用代码")
    private String enttqxbssztpsciFcreditno;


    @TableField("enttqxbssztpsci_name")
    @ApiModelProperty(name="enttqxbssztpsciName" , value = "股东姓名")
    private String enttqxbssztpsciName;


    @TableField("enttqxbssztpsci_fidentifyno")
    @ApiModelProperty(name="enttqxbssztpsciFidentifyno" , value = "股东证件号码")
    private String enttqxbssztpsciFidentifyno;


    @TableField("enttqxbssztpsci_fshoudcapi")
    @ApiModelProperty(name="enttqxbssztpsciFshoudcapi" , value = "认缴出资额")
    private String enttqxbssztpsciFshoudcapi;


    @TableField("enttqxbssztpsci_finvesttype")
    @ApiModelProperty(name="enttqxbssztpsciFinvesttype" , value = "出资方式")
    private String enttqxbssztpsciFinvesttype;


    @TableField("enttqxbssztpsci_fshouldcapidate")
    @ApiModelProperty(name="enttqxbssztpsciFshouldcapidate" , value = "出资时间")
    private String enttqxbssztpsciFshouldcapidate;


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
