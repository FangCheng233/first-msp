package com.fc.msp.mspcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MspCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MspCenterApplication.class, args);
    }

}
