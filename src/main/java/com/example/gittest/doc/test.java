package com.example.gittest.doc;

import com.google.common.collect.Lists;
import com.sun.deploy.net.MessageHeader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Component
public class test {

    public static List<String> social_credit_code_lists = Lists.newArrayList();
    @Resource
    ListInit listInit;


    @PostConstruct
    public void init() {
        social_credit_code_lists = listInit.initList();
        log.info("ODpEntListCache====>oDpEntList.size" + social_credit_code_lists.size());
    }

    public List<String> getListByPage(Integer Index, Integer Size) {
        int start=Index * Size - Size;
        int end=Index * Size;
        if (end>=social_credit_code_lists.size()){
            end=social_credit_code_lists.size();
        }
        return social_credit_code_lists.subList(start, end);
    }
    public Integer getListTotol() {
        return social_credit_code_lists.size();
    }


}
