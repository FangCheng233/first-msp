package com.fc.msp.zkclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fc.msp.config.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ZKClientFactory
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/18 9:29 下午
 * @Version 1.0
 */
@Slf4j
@Component
public class ZKClientFactory {
    @Autowired
    ZookeeperConfig zookeeperConfig;

    public static volatile ConcurrentHashMap<String, ZooKeeper> concurrentHashMap = new ConcurrentHashMap(16);
    public static volatile JSONObject jsonObject = new JSONObject();
    @PostConstruct
    public void createConnection(){
        // 获取配置文件信息 读取加载多个环境配置
        getInitValue();
        for (ZookeeperConfig.Config config: zookeeperConfig.getConfigList()) {
            ZookeeperClient zookeeperClient = new ZookeeperClient(config.getZkUrl(),config.getEnv(), config.getTimeout());
            zookeeperClient.connect();
        }
    }
    /**
     * Gets the value of jsonObject. *
     *
     * @return the value of jsonObject
     */
    public JSONObject getJsonObject() {
        return jsonObject;
    }

    /**
     * Sets the jsonObject. *
     * <p>You can use getJsonObject() to get the value of jsonObject</p>
     * * @param jsonObject jsonObject
     */
    public void setJsonObject(JSONObject jsonObject) {
        ZKClientFactory.jsonObject = jsonObject;
    }

    /**
     * Gets the value of zookeeperConfig. *
     *
     * @return the value of zookeeperConfig
     */
    public ZooKeeper getClient() {
        String env = LoginInterceptor.threadLocal.get();
        ZooKeeper client = concurrentHashMap.get(env);
        return client;
    }
    public ZooKeeper getClient(String env) {
        ZooKeeper client = concurrentHashMap.get(env);
        return client;
    }
    public JSONObject getInitValue(){
        String jsonStr = "";
        try {
            String path = this.getClass().getClassLoader().getResource("init.json").getPath();
            File jsonFile = new File(path);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            jsonObject = JSON.parseObject(jsonStr);
        } catch (IOException e) {
            log.warn("读取配置文件异常");
        } catch (NullPointerException e){

        }
        return jsonObject;
    }
}
