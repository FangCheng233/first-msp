package com.fc.msp.service;

import com.fc.msp.response.EchartsData;
import com.fc.msp.util.CmdUtil;
import com.fc.msp.vo.ClusterNode;
import com.fc.msp.zkclient.ZookeeperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ClusterNodeService
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/20 5:53 下午
 * @Version 1.0
 */
@Component
public class ClusterNodeService {
    @Autowired
    ZookeeperConfig zookeeperConfig;

    private String target = "";
    public List<ClusterNode> getNodeType(String env){
        List<ClusterNode> nodes = new ArrayList<>(4);
        for(ZookeeperConfig.Config config:zookeeperConfig.getConfigList()){
            if(config.getEnv().equalsIgnoreCase(env)){
                String[] urls = config.getZkUrl().split(",");
                for(String url:urls){
                    String type =  CmdUtil.INSTANCE.executeCmd2("stat","Mode: ", url);
                    if(type == "leader"||type.equalsIgnoreCase("leader")){
                        target = url;
                    }
                    ClusterNode node = new ClusterNode(url,type==""?0:1,type);
                    nodes.add(node);
                }

            }
        }
        return nodes;
    }
    public List<EchartsData> creatRes(String env){
        List<EchartsData> echartsDataList = new ArrayList<>(4);
        for(ClusterNode clusterNode:getNodeType(env)){
            EchartsData echartsData = new EchartsData(
                    clusterNode.getNodeType().equalsIgnoreCase("leader")?80:40,
                    clusterNode.getNodeName(),
                    clusterNode.getNodeName(),clusterNode.getNodeType()!=""?target:"",
                    clusterNode.getNodeType());
            echartsDataList.add(echartsData);
        }
        return echartsDataList;
    }
}
