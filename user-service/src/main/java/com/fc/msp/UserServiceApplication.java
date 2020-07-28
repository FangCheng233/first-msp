package com.fc.msp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName UserServiceApplication
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/22 8:11 上午
 * @Version 1.0
 */
@Controller
@RequestMapping("/")
@EnableEurekaClient
@SpringBootApplication
public class UserServiceApplication {
    @PostMapping("getName1")
    public String getUserName(){
        return "123";
    }
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
