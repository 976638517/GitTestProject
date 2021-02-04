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
 * 数据接入返回字段
 * @author zhulei
 * @date 2021-01-26 13:59:19
 */
@Data
@ApiModel("import_data_response_field")
@TableName("import_data_response_field")
public class ImportDataResponseField {/**
    *自增主键id
     */

    @TableId(value = "id" , type = IdType.AUTO)
    @ApiModelProperty(name="id" , value = "自增主键id")
    private Integer id;

    /**
    *修改时间
     */

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("updata_time")
    @ApiModelProperty(name="updataTime" , value = "修改时间")
    private java.util.Date updataTime;

    /**
    *创建时间
     */

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    @ApiModelProperty(name="createTime" , value = "创建时间")
    private java.util.Date createTime;

    /**
    *access_source_property的id
     */

    @TableField("access_source_property_id")
    @ApiModelProperty(name="accessSourcePropertyId" , value = "access_source_property的id")
    private Integer accessSourcePropertyId;

    /**
    *import_data_table的id
     */

    @TableField("import_data_table_id")
    @ApiModelProperty(name="importDataTableId" , value = "import_data_table的id")
    private Integer importDataTableId;

    /**
    *字段名
     */

    @TableField("field_name")
    @ApiModelProperty(name="fieldName" , value = "字段名")
    private String fieldName;

    /**
    *字段父id
     */

    @TableField("parent_id")
    @ApiModelProperty(name="parentId" , value = "字段父id")
    private Integer parentId;

    /**
    *0-jsonObject 1-jsonArray
     */

    @TableField("json_type")
    @ApiModelProperty(name="jsonType" , value = "0-jsonObject 1-jsonArray")
    private Integer jsonType;

    /**
    *分页字段标识size、total、current
     */

    @TableField("special_field")
    @ApiModelProperty(name="specialField" , value = "分页字段标识size、total、current等")
    private String specialField;

    /**
    *描述
     */

    @TableField("description")
    @ApiModelProperty(name="description" , value = "描述")
    private String description;


    /**
     *json串 对应name的value
     */

    @TableField(exist = false)
    @ApiModelProperty(name="jsonValue" , value = "json串 对应name的value")
    private Object jsonValue;



}
