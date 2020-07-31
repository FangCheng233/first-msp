package com.fc.msp.mspmail.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.enums.PropertyChangeType;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ApolloConfiguration
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/29 8:20 上午
 * @Version 1.0
 */
@Component
@Configuration
public class ApolloConfiguration {

    @ApolloConfig("subscription")
    Config config;
    @Resource
    UserConfig userConfig;
    @Bean
    public ApolloConfiguration ApolloConfiguration() {
        return new ApolloConfiguration();
    }

    /**
     * Gets the value of config. *
     *
     * @return the value of config
     */
    public Config getConfig() {
        return config;
    }

    /**
     * Sets the config. *
     * <p>You can use getConfig() to get the value of config</p>
     * * @param config config
     */
    public void setConfig(Config config) {
        this.config = config;
    }

    @PostConstruct
    private void setConfig(){
        Set<String> list = config.getPropertyNames();
        Map<String, String> map = new HashMap<>();
        for(String user:list){
            map.put(user, config.getProperty(user,""));
        }
        userConfig.setUserList(map);
    }

    @ApolloConfigChangeListener("subscription")
    private void atApolloConfigChanging(ConfigChangeEvent changeEvent){
        Set<String> list = changeEvent.changedKeys();
        for(String user:list){
            if(changeEvent.getChange(user).getChangeType().equals(PropertyChangeType.DELETED)){
                userConfig.getUserList().remove(user);
            }else {
                userConfig.getUserList().put(user, config.getProperty(user,""));
            }
        }
    }
    @ApolloConfigChangeListener("application")
    private void apolloConfigChanging(ConfigChangeEvent changeEvent){
        if(changeEvent.getChange("usermail").getChangeType().equals(PropertyChangeType.MODIFIED)){
            userConfig.setUser(changeEvent.getChange("usermail").getNewValue());
        }
        if(changeEvent.getChange("password").getChangeType().equals(PropertyChangeType.MODIFIED)){
            userConfig.setPassword(changeEvent.getChange("password").getNewValue());
        }
    }
}
