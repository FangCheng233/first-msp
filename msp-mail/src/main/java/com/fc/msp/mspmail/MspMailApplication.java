package com.fc.msp.mspmail;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableApolloConfig
@SpringBootApplication
public class MspMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MspMailApplication.class, args);
    }

}
