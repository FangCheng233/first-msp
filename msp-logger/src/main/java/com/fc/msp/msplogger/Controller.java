package com.fc.msp.msplogger;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Controller
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/4 2:56 下午
 * @Version 1.0
 */
@RestController("/")
public class Controller {
    @ApolloConfig
    Config config;
    @Autowired
    Message message;
    @GetMapping("apollo")
    public String apolloTest(){
        Map map = new HashMap();
        while (true){
            System.out.println("@ApolloConfig" + config.getProperty("apolloConfig","default"));
            System.out.println("@Value" + message.getMessage());
        }
    }
}
