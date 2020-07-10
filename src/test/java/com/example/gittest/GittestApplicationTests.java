package com.example.gittest;

import com.example.gittest.bean.DeptVo;
import com.example.gittest.bean.EmpVo;
import com.example.gittest.dao.DeptVoMapper;
import com.example.gittest.dao.EmpVoMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class GittestApplicationTests {
    @Autowired
    EmpVoMapper empVoMapper;
    @Autowired
    DeptVoMapper deptVoMapper;

    @Test
    void contextLoads() {
        List<DeptVo> list=new LinkedList<>();
        DeptVo a=new DeptVo();
        a.setDeptno(50);
        a.setDname("AAAA");
        a.setLoc("BJ");
        list.add(a);
        DeptVo b=new DeptVo();
        b.setDeptno(60);
        b.setDname("BBBB");
        b.setLoc("BJ");
        list.add(b);
        DeptVo c=new DeptVo();
        c.setDeptno(70);
        c.setDname("BBBB");
        c.setLoc("BJ");
        list.add(c);
        deptVoMapper.insertDeptlist(list);
    }

}
