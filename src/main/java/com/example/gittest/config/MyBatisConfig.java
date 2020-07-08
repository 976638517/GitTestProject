package com.example.gittest.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Configuration;

@MapperScan(value = "com.example.gittest.dao")
@Configuration
public class MyBatisConfig {
    public ConfigurationCustomizer configurationCustomizer(){

        return new ConfigurationCustomizer(){
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //开启驼峰命名规则匹配
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
