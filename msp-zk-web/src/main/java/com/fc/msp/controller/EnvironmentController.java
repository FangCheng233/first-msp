package com.fc.msp.controller;

import com.alibaba.fastjson.JSONObject;
import com.fc.msp.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EnvermentController
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/19 9:30 下午
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/")
public class EnvironmentController {

    @Autowired
    EnvironmentService service;

    @GetMapping(value = "/env")
    public JSONObject getEnv(){
        return service.creatMenu();
    }
}
