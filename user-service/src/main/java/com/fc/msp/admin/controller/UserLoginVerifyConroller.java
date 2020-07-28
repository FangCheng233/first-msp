package com.fc.msp.admin.controller;

import com.fc.msp.admin.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @ClassName UserLoginVerifyConroller
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/28 2:26 下午
 * @Version 1.0
 */
@RestController("/")
public class UserLoginVerifyConroller {
    @Resource
    UserService userService;

    @GetMapping("getName")
    public String getUserName(){
            return userService.selectByPrimaryKey(1).getUsername();
    }
    @PostConstruct
    public void print(){
        System.out.println("启动了！");
    }
}
