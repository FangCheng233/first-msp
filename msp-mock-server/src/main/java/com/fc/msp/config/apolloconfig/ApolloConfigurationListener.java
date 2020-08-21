package com.fc.msp.config.apolloconfig;

import com.alibaba.fastjson.JSON;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.enums.PropertyChangeType;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ApolloConfigurationListener
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/20 10:01 下午
 * @Version 1.0
 */
@Slf4j
public class ApolloConfigurationListener {

    @ApolloConfig
    Config serviceConfig;
    @ApolloConfig
    Config responseConfig;

    public volatile static Map<String, String> responseData = new ConcurrentHashMap<>(16);
    public volatile static Map<String, MockConfig> mockConfigs = new ConcurrentHashMap<>(16);

    /**
     * Gets the value of responseData. *
     *
     * @return the value of responseData
     */
    public static Map<String, String> getResponseData() {
        return responseData;
    }

    /**
     * Gets the value of mockConfigs. *
     *
     * @return the value of mockConfigs
     */
    public static Map<String, MockConfig> getMockConfigs() {
        return mockConfigs;
    }

    /**
     *
     * @Description 初始化应用返回信息、启动端口
     * @Author fangcheng
     * @return void
     * @throws
     * @Date 2020/8/21 4:27 下午
     */
    @PostConstruct
    private void init(){
        for (String property : responseConfig.getPropertyNames()) {
            responseData.put(property, responseConfig.getProperty(property,""));
        }
        for(String service : serviceConfig.getPropertyNames()){
            MockConfig mockConfig = JSON.parseObject(serviceConfig.getProperty(service,""), MockConfig.class);
            mockConfigs.put(service, mockConfig);
        }
    }
    /**
     *
     * @Description 响应数据更新时更新内存中的响应数据
     * @Author fangcheng
     * @param changeEvent :
     * @return void
     * @throws
     * @Date 2020/8/21 4:15 下午
     */
    @ApolloConfigChangeListener("responseData")
    private synchronized void responseDataChange(ConfigChangeEvent changeEvent){
        for(String res : changeEvent.changedKeys()){
            if(changeEvent.getChange(res).getChangeType().equals(PropertyChangeType.ADDED)){
                responseData.put(res, changeEvent.getChange(res).getNewValue());
            }else if(changeEvent.getChange(res).getChangeType().equals(PropertyChangeType.MODIFIED)){
                responseData.put(res, changeEvent.getChange(res).getNewValue());
            }else {
                responseData.remove(res);
            }
        }
    }
    /**
     *
     * @Description 新增接口或者端口
     * @Author fangcheng
     * @param changeEvent :
     * @return void
     * @throws
     * @Date 2020/8/21 4:15 下午
     */
    @ApolloConfigChangeListener("application")
    private synchronized void interfaceChange(ConfigChangeEvent changeEvent){
        for(String service : changeEvent.changedKeys()){
            MockConfig mockConfig = null;
            try {
                mockConfig = JSON.parseObject(changeEvent.getChange(service).getNewValue(), MockConfig.class);
            }catch (Exception e){
                log.error("数据异常");
            }
            if(changeEvent.getChange(service).getChangeType().equals(PropertyChangeType.ADDED)){
                if(mockConfig.getType().equalsIgnoreCase("TCP")){
                    //开启新端口
                }
            }else if(changeEvent.getChange(service).getChangeType().equals(PropertyChangeType.MODIFIED)){

            }else {

            }
        }
    }
}
