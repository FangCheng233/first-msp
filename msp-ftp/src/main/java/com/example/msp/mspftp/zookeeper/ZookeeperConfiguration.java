package com.example.msp.mspftp.zookeeper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName ZookeeperConfiguration
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/22 1:45 下午
 * @Version 1.0
 */

@Component
@Configuration
public class ZookeeperConfiguration {

    public String CONNECT_STRING = "";

    public int SESSION_TIMEOUT = 2000;

    @Value("${zk.connectURL:127.0.0.1:2181}")
    public void setConnectString(String connectString) {
        CONNECT_STRING = connectString;
    }

    @Value("${zk.sessionTimeout:2000}")
    public void setSessionTimeout(int sessionTimeout) {
        SESSION_TIMEOUT = sessionTimeout;
    }

    public String getConnectString() {
        return CONNECT_STRING;
    }

    public int getSessionTimeout() {
        return SESSION_TIMEOUT;
    }
    @PostConstruct
    public ZookeeperConfiguration getInstance(){
        return new ZookeeperConfiguration();
    }
}
