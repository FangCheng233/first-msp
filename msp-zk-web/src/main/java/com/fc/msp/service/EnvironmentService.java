package com.fc.msp.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fc.msp.zkclient.ZKClientFactory;
import com.fc.msp.zkclient.ZookeeperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.fc.msp.zkclient.ZKClientFactory.jsonObject;


/**
 * @ClassName EnvironmentService
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/19 9:35 下午
 * @Version 1.0
 */
@Component
public class EnvironmentService {
    @Autowired
    ZKClientFactory zkClientFactory;
    @Autowired
    ZookeeperConfig zookeeperConfig;

    public JSONObject creatMenu(){

        /*JSONObject menuConfig = new JSONObject();
        JSONObject homeInfo = new JSONObject();
        homeInfo.put("title", "首页");
        homeInfo.put("href", "page/welcome-1.html?t=1");
        JSONObject logoInfo = new JSONObject();
        logoInfo.put("title","Zookeeper Client");
        logoInfo.put("image","images/logo.png");
        logoInfo.put("href", "");
        menuConfig.put("",homeInfo);
        menuConfig.put("",logoInfo);
        JSONArray menuInfo = new JSONArray();
        JSONObject env = JSON.parseObject("");
        for(ZookeeperConfig.Config config:zookeeperConfig.getConfigList()){
            JSONObject env = new JSONObject();
            env.put("title", config.getEnv());
            env.put("icon", "fa fa-address-book");
            env.put("env", env);
            env.put("href", "");
            env.put("target", "_self");
            JSONArray child = new JSONArray();
            JSONObject page = new JSONObject();
            JSONArray childchild = new JSONArray();
        }*/
        JSONObject menu = jsonObject.getJSONArray("menuInfo").getJSONObject(0);
        JSONArray list = jsonObject.getJSONArray("menuInfo");
        list.clear();
        for(ZookeeperConfig.Config config : zookeeperConfig.getConfigList()){
            JSONObject page = JSON.parseObject(menu.toJSONString());
            page.put("title",config.getEnv());
            page.put("env",config.getEnv());
            list.add(page);
        }
        jsonObject.put("menuInfo",list);
        return jsonObject;
    }
}
