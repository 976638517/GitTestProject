package com.example.gittest.service.ServiceImpl;

import com.example.gittest.bean.EmpVo;
import com.example.gittest.bean.EmpVoExample;
import com.example.gittest.dao.DeptVoMapper;
import com.example.gittest.dao.EmpVoMapper;
import com.example.gittest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        EmpVoExample empVoExample =new EmpVoExample();
        EmpVoExample.Criteria criteria=empVoExample.createCriteria();
        criteria.andEmpnoEqualTo(empno);
        return empVoMapper.selectByExample(empVoExample);
    }

    @Override
    public List<EmpVo> selectEmpByEmame(String ename) {
        EmpVoExample empVoExample =new EmpVoExample();
        EmpVoExample.Criteria criteria=empVoExample.createCriteria();
        criteria.andEnameLike(ename);
        return  empVoMapper.selectByExample(empVoExample);
    }

    @Override
    public List<EmpVo> selectEmpByJob(String job) {
        EmpVoExample empVoExample =new EmpVoExample();
        EmpVoExample.Criteria criteria=empVoExample.createCriteria();
        criteria.andJobEqualTo(job);
        return empVoMapper.selectByExample(empVoExample);
    }

    @Override
    public List<EmpVo> selectEmpByMgr(Integer mgr) {
        EmpVoExample empVoExample =new EmpVoExample();
        EmpVoExample.Criteria criteria=empVoExample.createCriteria();
        criteria.andMgrEqualTo(mgr);
        return empVoMapper.selectByExample(empVoExample);
    }

    @Override
    public List<EmpVo> selectEmpByDate() {
        return null;
    }

    @Override
    public List<EmpVo> selectEmpBySal() {
        return null;
    }

    @Override
    public List<EmpVo> selectEmpByComm() {
        return null;
    }

    @Override
    public int addEmp(EmpVo empVo) {
        return 0;
    }

    @Override
    public int deleteEmp(EmpVo empVo) {
        return 0;
    }

    @Override
    public int updateEmp(EmpVo empVo) {
        return 0;
    }
}
