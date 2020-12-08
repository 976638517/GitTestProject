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
 * 企业明细-基本信息-工商信息(启信宝)-变更信息
 * @author zhulei
 * @date 2020-12-04 14:47:44
 */
@Data
@ApiModel("o_dp_gsxx_bgxx")
@TableName("o_dp_gsxx_bgxx")
public class ODpGsxxBgxx {


    @TableId(value = "id" , type = IdType.AUTO)
    @ApiModelProperty(name="id" , value = "主键ID")
    private Integer id;


    @TableField("enttqxbssztc_fname")
    @ApiModelProperty(name="enttqxbssztcFname" , value = "企业名称")
    private String enttqxbssztcFname;


    @TableField("enttqxbssztc_fcreditno")
    @ApiModelProperty(name="enttqxbssztcFcreditno" , value = "统一社会信用代码")
    private String enttqxbssztcFcreditno;


    @TableField("enttqxbssztc_fchangeitem")
    @ApiModelProperty(name="enttqxbssztcFchangeitem" , value = "变更项目")
    private String enttqxbssztcFchangeitem;


    @TableField("enttqxbssztc_fchangedate")
    @ApiModelProperty(name="enttqxbssztcFchangedate" , value = "变更日期")
    private String enttqxbssztcFchangedate;


    @TableField("enttqxbssztc_fbeforecontent")
    @ApiModelProperty(name="enttqxbssztcFbeforecontent" , value = "变更前内容")
    private String enttqxbssztcFbeforecontent;


    @TableField("enttqxbssztc_faftercontent")
    @ApiModelProperty(name="enttqxbssztcFaftercontent" , value = "变更后内容")
    private String enttqxbssztcFaftercontent;


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
