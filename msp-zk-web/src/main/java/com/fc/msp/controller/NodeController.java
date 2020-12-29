package com.fc.msp.controller;

import com.fc.msp.response.EchartsData;
import com.fc.msp.service.ClusterNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName NodeController
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/20 4:57 下午
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/node")
public class NodeController {
    @Autowired
    ClusterNodeService clusterNodeService;

    @GetMapping("/list")
    public List<EchartsData> getNodeList(String env){
        if(env==null||env==""){
            throw new  NullPointerException();
        }
        return clusterNodeService.creatRes(env);
    }
}
