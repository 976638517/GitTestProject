package com.example.gittest.doc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class testTask {
    public static char a='a';
    @Scheduled(fixedDelay = 1000*5)
    public void Flash(){
        for (int i = 0; i < 5; i++) {
            a=a++;
            test.social_credit_code_lists.add(i+a+"");
        }
    }
}
