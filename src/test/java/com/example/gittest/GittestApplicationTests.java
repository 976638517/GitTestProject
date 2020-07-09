package com.example.gittest;

import com.example.gittest.bean.EmpVo;
import com.example.gittest.dao.EmpVoMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
class GittestApplicationTests {
    @Autowired
    EmpVoMapper empVoMapper;

    @Test
    void contextLoads() {
        EmpVo empVo =new EmpVo();
        empVo.setEmpno(1111);
        empVo.setEname("2222");
        empVoMapper.insert(empVo);
    }

}
