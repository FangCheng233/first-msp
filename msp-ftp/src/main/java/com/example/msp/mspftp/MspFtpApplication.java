package com.example.msp.mspftp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MspFtpApplication {

    public static void main(String[] args) {
        SpringApplication.run(MspFtpApplication.class, args);
    }

}
