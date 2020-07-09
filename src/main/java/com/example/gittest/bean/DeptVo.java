package com.example.gittest.bean;

import java.util.List;

public class DeptVo {
    private Integer deptno;

    private String dname;

    private String loc;

    private List<EmpVo> empVoList;

    public List<EmpVo> getEmpVoList() {
        return empVoList;
    }

    public void setEmpVoList(List<EmpVo> empVoList) {
        this.empVoList = empVoList;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }
}