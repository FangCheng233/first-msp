package com.example.msp.mspftp.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName ZkClien
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/22 1:40 下午
 * @Version 1.0
 */
public class ZkClient {
    private ZooKeeper zkClient;

    public static String CONNECT_STRING = "192.168.11.17:2181,192.168.11.18:2181,192.168.11.19:2181";

    public static int SESSION_TIMEOUT = 60000;

    @Before
    public void before() throws IOException {

        zkClient = new ZooKeeper(CONNECT_STRING, SESSION_TIMEOUT, e -> { System.out.println("执行回调函数！"); });
    }
    @Test
    public void ls() throws Exception {
        List<String> children = zkClient.getChildren("/", e->{
            System.out.println("默认回调函数！");
        });
        for(String child : children){
            System.out.println(child);
        }
        Thread.sleep(Long.MAX_VALUE);
    }
    @Test
    public void create() throws Exception {
        for(int i = 0; i < 100; i++){
            String path = zkClient.create("/Idea/zookeeper", "Idea2020".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        }
    }
    @Test
    public void getData() throws Exception {
        byte[] data = zkClient.getData("/Idea", true, new Stat());
        System.out.println(new String(data));
    }

}
