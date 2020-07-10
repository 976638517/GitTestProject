package com.example.gittest.service.ServiceImpl;

import com.example.gittest.bean.DeptVo;
import com.example.gittest.bean.EmpVo;
import com.example.gittest.bean.EmpVoExample;
import com.example.gittest.dao.DeptVoMapper;
import com.example.gittest.dao.EmpVoMapper;
import com.example.gittest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    DeptVoMapper deptVoMapper;
    @Autowired
    EmpVoMapper empVoMapper;

    @Override
    public List<EmpVo> selectEmpAll() {
        return empVoMapper.selectAll();
    }

    @Override
    public List<EmpVo> selectEmpByEmpno(Integer empno) {
        EmpVoExample empVoExample = new EmpVoExample();
        EmpVoExample.Criteria criteria = empVoExample.createCriteria();
        criteria.andEmpnoEqualTo(empno);
        return empVoMapper.selectByExample(empVoExample);
    }

    @Override
    public List<EmpVo> selectEmpByEmame(String ename) {
        EmpVoExample empVoExample = new EmpVoExample();
        EmpVoExample.Criteria criteria = empVoExample.createCriteria();
        criteria.andEnameLike(ename);
        return empVoMapper.selectByExample(empVoExample);
    }

    @Override
    public List<EmpVo> selectEmpByJob(String job) {
        EmpVoExample empVoExample = new EmpVoExample();
        EmpVoExample.Criteria criteria = empVoExample.createCriteria();
        criteria.andJobEqualTo(job);
        return empVoMapper.selectByExample(empVoExample);
    }

    @Override
    public List<EmpVo> selectEmpByMgr(Integer mgr) {
        EmpVoExample empVoExample = new EmpVoExample();
        EmpVoExample.Criteria criteria = empVoExample.createCriteria();
        criteria.andMgrEqualTo(mgr);
        return empVoMapper.selectByExample(empVoExample);
    }

    @Override
    public List<EmpVo> selectEmpByDate(String a,String b) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        EmpVoExample empVoExample=new EmpVoExample();
        try {
            Date aa=  format.parse(a);
            Date bb=  format.parse(b);
            EmpVoExample.Criteria criteria=empVoExample.createCriteria();
            criteria.andHiredateBetween(aa,bb);
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Spring转换data错误");
        }
        return empVoMapper.selectByExample(empVoExample);
    }

    @Override
    public List<EmpVo> selectEmpBySal(Integer sal) {
        EmpVoExample empVoExample = new EmpVoExample();
        EmpVoExample.Criteria criteria = empVoExample.createCriteria();
        criteria.andSalGreaterThanOrEqualTo(sal);
        return empVoMapper.selectByExample(empVoExample);
    }

    @Override
    public List<EmpVo> selectEmpByComm(Integer comm) {
        EmpVoExample empVoExample = new EmpVoExample();
        EmpVoExample.Criteria criteria = empVoExample.createCriteria();
        criteria.andCommLessThanOrEqualTo(comm);
        return empVoMapper.selectByExample(empVoExample);
    }


    @Override
    public int addEmp(EmpVo empVo) {
        return empVoMapper.insert(empVo);
    }

    @Override
    public int deleteEmp(EmpVo empVo) {
        EmpVoExample empVoExample = new EmpVoExample();
        EmpVoExample.Criteria criteria = empVoExample.createCriteria();
        criteria.andEmpnoEqualTo(empVo.getEmpno());
        return empVoMapper.deleteByExample(empVoExample);
    }

    @Override
    public int updateEmp(EmpVo empVo) {
        return empVoMapper.updateByPrimaryKey(empVo);
    }

    @Override
    public List<EmpVo> empAndDept(Integer id) {
        return empVoMapper.empAndDept(id);
    }

    @Override
    public List<DeptVo> selectDeptAndEmp() {
        return deptVoMapper.selectDeptAndEmp();
    }

    @Override
    public List<EmpVo> selectBywhere(EmpVo empVo) {
        return empVoMapper.selectBywhere(empVo);
    }

    @Override
    public int updataBySet(EmpVo empVo) {
        return empVoMapper.updataBySet(empVo);
    }

    @Override
    public int insertDeptlist(List<DeptVo> deptlist) {
        return deptVoMapper.insertDeptlist(deptlist);
    }
}
