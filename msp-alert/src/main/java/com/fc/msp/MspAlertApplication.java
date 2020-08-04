package com.fc.msp;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.fc.msp.notify.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;

@EnableAsync
@EnableApolloConfig
@SpringBootApplication
public class MspAlertApplication {

    public static void main(String[] args) {
        SpringApplication.run(MspAlertApplication.class, args);
    }

}
