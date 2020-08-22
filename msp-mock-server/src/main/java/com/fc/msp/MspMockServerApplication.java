package com.fc.msp;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableApolloConfig
@EnableEurekaClient
@SpringBootApplication
public class MspMockServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MspMockServerApplication.class, args);
    }

}
