package com.example.msp.mspftp.zookeeper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ZookeeperConfiguration
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/22 1:45 下午
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "zk")
public class ZookeeperConfiguration {
    @Value("${connectURL}")
    public static final String CONNECT_STRING = "127.0.0.1:2181";
    @Value("${sessionTimeout}")
    public static final int SESSION_TIMEOUT = 2000;

}
