package com.example.gittest.doc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ListInit {
    public List<String> initList(){
        for (int i = 0; i < 500; i++) {
            test.social_credit_code_lists.add(i+"");
        }
        return test.social_credit_code_lists;
    }
}
