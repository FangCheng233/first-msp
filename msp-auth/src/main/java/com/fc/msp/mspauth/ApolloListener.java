package com.fc.msp.mspauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName ApolloListener
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/31 11:29 上午
 * @Version 1.0
 */
@Component
public class ApolloListener implements ApplicationRunner {
    @Autowired
    BaseConfig baseConfig;
    @PostConstruct
    private void printvalue(){
        System.out.println("value1  " + baseConfig.getValue1());
        System.out.println("value2  " + baseConfig.getValue2());
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
