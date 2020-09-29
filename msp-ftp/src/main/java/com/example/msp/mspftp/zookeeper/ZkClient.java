package com.example.msp.mspftp.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
//import org.junit.Before;
//import org.junit.Test;

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
    private static ZooKeeper zkClient;

    public static String CONNECT_STRING = "192.168.1.103:12181,192.168.1.103:22181,192.168.1.103:32181";

    public static int SESSION_TIMEOUT = 60000;

    public static void main(String[] args) {

    }
//    @Before
    public void before() throws IOException {

        zkClient = new ZooKeeper(CONNECT_STRING, SESSION_TIMEOUT, e -> { System.out.println("执行回调函数！"); });
    }
//    @Test
    public void ls() throws Exception {
        List<String> children = zkClient.getChildren("/", e->{
            System.out.println("默认回调函数！");
        });
        for(String child : children){
            System.out.println(child);
        }
        Thread.sleep(Long.MAX_VALUE);
    }
//    @Test
    public void create() throws Exception {
        for(int i = 0; i < 100; i++){
            String path = zkClient.create("/Idea/zookeeper", "Idea2020".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        }
    }
//    @Test
    public void getData() throws Exception {
        byte[] data = zkClient.getData("/Idea", true, new Stat());
        System.out.println(new String(data));
    }

    /**
     * Gets the value of zkClient. *
     *
     * @return the value of zkClient
     */
    public static ZooKeeper getZkClient() {
        return zkClient;
    }
}
