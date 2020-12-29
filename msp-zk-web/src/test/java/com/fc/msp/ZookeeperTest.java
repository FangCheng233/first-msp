package com.fc.msp;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * @ClassName ZookeeperTest
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/21 11:05 下午
 * @Version 1.0
 */
public class ZookeeperTest {
    private static ZooKeeper client;
    static String path = "/dubbo";
    public static void main(String[] args) {
        try {
             client = new ZooKeeper("192.168.1.103:12181", 600000, new MyWatcher());

            client.getChildren(path, new DataWatcher(path));
            Thread.sleep(1000000000);
            System.out.println("data");
        }catch (Exception e){

        }
    }
    public static class MyWatcher implements Watcher{

        @Override
        public void process(WatchedEvent watchedEvent) {
        }
    }
    public static class DataWatcher implements Watcher{
        String path;

        public DataWatcher(String path) {
            this.path = path;
        }

        @Override
        public void process(WatchedEvent watchedEvent) {
            try {
                client.getChildren(path, new DataWatcher(path));
            }catch (Exception e){

            }
            if (watchedEvent.getType() == Event.EventType.NodeCreated) {
                System.out.println("NodeCreated" + watchedEvent.getType());
            }
            if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
                System.out.println("NodeDeleted" + watchedEvent.getType());
            }
            if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                System.out.println("NodeDataChanged" + watchedEvent.getType());
            }
            if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                System.out.println("NodeChildrenChanged" + watchedEvent.getType());
            }
            if (watchedEvent.getType() == Event.EventType.ChildWatchRemoved) {
                System.out.println("ChildWatchRemoved" + watchedEvent.getType());
            }
        }
    }
}
