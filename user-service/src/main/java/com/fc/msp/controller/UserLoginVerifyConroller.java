package com.fc.msp.controller;

import com.fc.msp.admin.mapper.UserMapper;
import com.fc.msp.admin.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @ClassName UserLoginVerifyConroller
 * @Description 用户登陆权限验证
 * @Author fangcheng
 * @Date 2020/7/28 2:26 下午
 * @Version 1.0
 */
@RestController("/")
public class UserLoginVerifyConroller {
    @Resource
    UserService userService;

    @Resource
    UserMapper userMapper;

    @GetMapping("getName")
    public String getUserName(){
            return userMapper.selectByPrimaryKey(1).getUsername();
    }
    @PostConstruct
    public void print(){
        System.out.println("启动了！");
    }
}
