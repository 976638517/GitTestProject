package com.example.gittest.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class EmpVo {
    @Excel(name = "empno", orderNum="1")
    private Integer empno;
    @Excel(name = "ename", orderNum="2")
    private String ename;
    @Excel(name = "job", orderNum="3")
    private String job;
    @Excel(name = "mgr", orderNum="4")
    private Integer mgr;
    @Excel(name = "hiredate", orderNum="5" ,exportFormat="yyyy-MM-dd" )
    private Date hiredate;
    @Excel(name = "sal", orderNum="6")
    private Integer sal;
    @Excel(name = "comm", orderNum="7")
    private Integer comm;
    @Excel(name = "deptno", orderNum="8")
    private Integer deptno;

    private DeptVo deptVo;

    public DeptVo getDeptVo() {
        return deptVo;
    }

    public void setDeptVo(DeptVo deptVo) {
        this.deptVo = deptVo;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getSal() {
        return sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }

    public Integer getComm() {
        return comm;
    }

    public void setComm(Integer comm) {
        this.comm = comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }
}