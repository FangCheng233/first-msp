package com.fc.msp.msplogger;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


@EnableApolloConfig
@EnableEurekaClient
@SpringBootApplication
public class MspLoggerApplication {
    @Resource
    Message message;
    public static void main(String[] args) {
        SpringApplication.run(MspLoggerApplication.class, args);
    }
    @PostConstruct
    private void test(){
        System.out.println(message.getMessage());
    }
}
