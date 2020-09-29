package com.fc.msp.db.service;

import com.fc.msp.db.dao.NodeConfigMapper;
import com.fc.msp.db.dto.NodeConfig;
import com.fc.msp.util.CmdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName DataCollection
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/20 11:57 下午
 * @Version 1.0
 */
@Component
public class DataCollection {
    @Autowired
    NodeConfigMapper configMapper;

    public void get(String env){
        // 获取采集列表
        List<NodeConfig> configs = configMapper.selectByEnv(env);
        // 获取信息
        for(NodeConfig nodeConfig : configs){
//            CmdUtil.INSTANCE.executeCmd2("")
        }
        // 信息入库

    }
}
