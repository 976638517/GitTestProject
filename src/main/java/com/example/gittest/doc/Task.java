package com.example.gittest.doc;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Slf4j
public class Task {

    @Resource
    test test;
    @Scheduled(fixedDelay = 1000 * 10)
    public void forList() {
        int index = 1;
        int total = 0;
        int szie = 50;
        while (true) {
            total=test.social_credit_code_lists.size();
            List<String> aprtList=test.getListByPage(index,szie);
            for (String s:
                 aprtList) {
                log.info(s);
            }
            if (szie * index >= total) {
                break;
            }
            index = index + 1;
        }


    }
}
