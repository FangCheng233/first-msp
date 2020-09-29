package com.fc.msp.zkclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.AddWatchMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ZookeeperClient
 * @Description 使用单例模式-懒汉式创建zookeeper连接
 * @Author fangcheng
 * @Date 2020/9/11 9:15 下午
 * @Version 1.0
 */
@Slf4j
public class ZookeeperClient {

    private String zkUrl;
    private String env;
    private int timeout;
    private static ZooKeeper client = null;
    public static CountDownLatch countDownLatch = new CountDownLatch(1);
    public ZookeeperClient(String zkUrl, String env, int timeout) {
        this.env = env;
        this.zkUrl = zkUrl;
        this.timeout = timeout;
    }
    /**
     *
     * @Description 添加守护线程对client的状态进行监听，如果断开则重新连接
     * @Author fangcheng
     * @return org.apache.zookeeper.ZooKeeper
     * @throws
     * @Date 2020/9/12 9:10 上午
     */
    public void connect(){
        try {
            client = new ZooKeeper(zkUrl, timeout,new ZookeeperClientWatcher());
        }catch (IOException exception){
            log.warn("zookeeper客户端连接异常，异常原因为{}", exception.getMessage());
        }
        ZKClientFactory.concurrentHashMap.put(env, client);
    }
    public static class ZookeeperClientWatcher implements Watcher {

        @Override
        public void process(WatchedEvent watchedEvent) {
            if (watchedEvent.getState() == Event.KeeperState.Expired) {
                close();

            }
            if(watchedEvent.getState() == Event.KeeperState.Disconnected){

            }
            if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                if(countDownLatch!=null){
                    countDownLatch.countDown();
                }
            }
        }

    }
    public static void close() {
        log.warn("连接会话超时，断开重新连接……");
        if ( client != null) {
            try {
                client.close();
                client = null;
            } catch (InterruptedException e) {
                //ignore exception
            }
        }
    }
}
