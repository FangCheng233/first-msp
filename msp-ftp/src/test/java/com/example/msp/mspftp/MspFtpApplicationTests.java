package com.example.msp.mspftp;

import com.example.msp.mspftp.zookeeper.ZkClient;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MspFtpApplicationTests {

    @Test
    void contextLoads() {
        ZooKeeper client = ZkClient.getZkClient();
    }

}
