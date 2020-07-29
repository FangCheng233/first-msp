package com.fc.msp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MspAlertApplication {

    public static void main(String[] args) {
        SpringApplication.run(MspAlertApplication.class, args);
    }

}
