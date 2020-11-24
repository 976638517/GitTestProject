package com.example.gittest.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;


public class DataYuan {
    //    中文名称：	审核人
    @Excel(name = "中文名称", width = 40,orderNum = "0")
    private String zwmc;
    //    内部标识符：	1329
    @Excel(name = "内部标识符", width = 10,orderNum = "1")
    private String nbbsf;
    //    字段名：	shr
    @Excel(name = "字段名", width = 10,orderNum = "3")
    private String zidm;
    //    定义：	项目，事项等的审核人。
    @Excel(name = "定义", width = 40,orderNum = "4")
    private String dy;
    //    同义名称：	审核者，评审人员
    @Excel(name = "同义名称", width = 40,orderNum = "5")
    private String tymc;
    //    数据类型：	字符型
    @Excel(name = "数据类型", width = 10,orderNum = "6")
    private String sjlx;
    //    数据格式：	an..10
    @Excel(name = "数据格式", width = 10,orderNum = "7")
    private String sjgs;
    //    计量单位：
    @Excel(name = "计量单位", width = 20,orderNum = "8")
    private String jldw;
    //    值域：
    @Excel(name = "值域", width = 20,orderNum = "9")
    private String zy;
    //    引用关系：	项目审核信息。
    @Excel(name = "引用关系", width = 40,orderNum = "10")
    private String yygx;
    //    有效性判断规则：	非空，姓名应符合人名命名习惯。。
    @Excel(name = "有效性判断规则", width = 40,orderNum = "11")
    private String yxxpdgz;
    //    是否公示：	是
    @Excel(name = "是否公示", width = 10,orderNum = "12")
    private String sfgs;
    //    数据产生方式：	登记管理部门提供。
    @Excel(name = "数据产生方式", width = 40,orderNum = "13")
    private String sjcsfs;
    //    备注：	参照GB/T 36104—2018数据元0008“法定代表人或负责人姓名”。
    @Excel(name = "备注", width = 40,orderNum = "14")
    private String bz;
    @Excel(name = "MySQL字段类型", width = 10,orderNum = "15")
    private String mysqlDataType;
    public DataYuan(){}

    @Override
    public String toString() {
        return "DataYuan{" +
                "zwmc='" + zwmc + '\'' +
                ", nbbsf='" + nbbsf + '\'' +
                ", zidm='" + zidm + '\'' +
                ", dy='" + dy + '\'' +
                ", tymc='" + tymc + '\'' +
                ", sjlx='" + sjlx + '\'' +
                ", sjgs='" + sjgs + '\'' +
                ", jldw='" + jldw + '\'' +
                ", zy='" + zy + '\'' +
                ", yygx='" + yygx + '\'' +
                ", yxxpdgz='" + yxxpdgz + '\'' +
                ", sfgs='" + sfgs + '\'' +
                ", sjcsfs='" + sjcsfs + '\'' +
                ", bz='" + bz + '\'' +
                ", mysqlDataType='" + mysqlDataType + '\'' +
                '}';
    }

    public DataYuan(String zwmc, String nbbsf, String zidm, String dy, String tymc, String sjlx, String sjgs, String jldw, String zy, String yygx, String yxxpdgz, String sfgs, String sjcsfs, String bz, String mysqlDataType) {
        this.zwmc = zwmc;
        this.nbbsf = nbbsf;
        this.zidm = zidm;
        this.dy = dy;
        this.tymc = tymc;
        this.sjlx = sjlx;
        this.sjgs = sjgs;
        this.jldw = jldw;
        this.zy = zy;
        this.yygx = yygx;
        this.yxxpdgz = yxxpdgz;
        this.sfgs = sfgs;
        this.sjcsfs = sjcsfs;
        this.bz = bz;
        this.mysqlDataType = mysqlDataType;
    }

    public String getMysqlDataType() {
        return mysqlDataType;
    }

    public void setMysqlDataType(String mysqlDataType) {
        this.mysqlDataType = mysqlDataType;
    }

    public String getZwmc() {
        return zwmc;
    }

    public void setZwmc(String zwmc) {
        this.zwmc = zwmc;
    }

    public String getNbbsf() {
        return nbbsf;
    }

    public void setNbbsf(String nbbsf) {
        this.nbbsf = nbbsf;
    }

    public String getZidm() {
        return zidm;
    }

    public void setZidm(String zidm) {
        this.zidm = zidm;
    }

    public String getDy() {
        return dy;
    }

    public void setDy(String dy) {
        this.dy = dy;
    }

    public String getTymc() {
        return tymc;
    }

    public void setTymc(String tymc) {
        this.tymc = tymc;
    }

    public String getSjlx() {
        return sjlx;
    }

    public void setSjlx(String sjlx) {
        this.sjlx = sjlx;
    }

    public String getSjgs() {
        return sjgs;
    }

    public void setSjgs(String sjgs) {
        this.sjgs = sjgs;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getYygx() {
        return yygx;
    }

    public void setYygx(String yygx) {
        this.yygx = yygx;
    }

    public String getYxxpdgz() {
        return yxxpdgz;
    }

    public void setYxxpdgz(String yxxpdgz) {
        this.yxxpdgz = yxxpdgz;
    }

    public String getSfgs() {
        return sfgs;
    }

    public void setSfgs(String sfgs) {
        this.sfgs = sfgs;
    }

    public String getSjcsfs() {
        return sjcsfs;
    }

    public void setSjcsfs(String sjcsfs) {
        this.sjcsfs = sjcsfs;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
