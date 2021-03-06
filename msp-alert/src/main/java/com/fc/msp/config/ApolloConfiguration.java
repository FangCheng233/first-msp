package com.fc.msp.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

    @ApolloConfig
    Config config;
    @Autowired
    AlertPushConfig alertPushConfig;
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
        if(config.getProperty(ConfigurationProperties.SEND_EMAIL,"") != null){
            alertPushConfig.setEnableEmail(config.getProperty(ConfigurationProperties.SEND_EMAIL,"true"));
        }
        if(config.getProperty(ConfigurationProperties.SEND_SMS,"") != null){
            alertPushConfig.setEnableSMS(config.getProperty(ConfigurationProperties.SEND_SMS,"true"));
        }
        if(config.getProperty(ConfigurationProperties.SEND_WECHAT,"") != null){
            alertPushConfig.setEnableWeChat(config.getProperty(ConfigurationProperties.SEND_WECHAT,"true"));
        }
    }

    @ApolloConfigChangeListener("application")
    private void atApolloConfigChanging(ConfigChangeEvent changeEvent){
        if(changeEvent.isChanged(ConfigurationProperties.SEND_EMAIL)){
            alertPushConfig.setEnableEmail(config.getProperty(ConfigurationProperties.SEND_EMAIL,"true"));
        }
        if(changeEvent.isChanged(ConfigurationProperties.SEND_SMS)){
            alertPushConfig.setEnableSMS(config.getProperty(ConfigurationProperties.SEND_SMS,"true"));
        }
        if(changeEvent.isChanged(ConfigurationProperties.SEND_WECHAT)){
            alertPushConfig.setEnableWeChat(config.getProperty(ConfigurationProperties.SEND_WECHAT,"true"));
        }
    }
}
