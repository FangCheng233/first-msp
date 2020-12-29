package com.fc.msp.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName AlertConfiguration
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/12/20 2:38 下午
 * @Version 1.0
 */
@Configuration
public class AlertConfiguration {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
