package com.example.msp.mspftp.zookeeper;

import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;

import java.io.IOException;

/**
 * @ClassName ZkClien
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/22 1:40 下午
 * @Version 1.0
 */
public class ZkClient {
    private ZooKeeper zooKeeper;

    @Before
    public void before() throws IOException {
        zooKeeper = new ZooKeeper(ZookeeperConfiguration.CONNECT_STRING, ZookeeperConfiguration.SESSION_TIMEOUT, e -> {});
    }
}
