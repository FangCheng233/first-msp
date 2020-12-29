package com.fc.msp.dao;

import com.fc.msp.vo.StatValueVO;
import com.fc.msp.zkclient.ZookeeperClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.data.StatPersisted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ZKDataDAO
 * @Description TODO  使用设计模式对节点操作优化
 * @Author fangcheng
 * @Date 2020/9/12 9:03 上午
 * @Version 1.0
 */

public interface ZookeeperDao {
    String getData(String path) throws KeeperException, InterruptedException;

    Stat getDataStat(String path) throws KeeperException, InterruptedException;

    List<ACL> getNodeAcl(String path) throws KeeperException, InterruptedException;

    Stat setNodeAcl(String path, List<ACL> acl, int version) throws KeeperException, InterruptedException;

    List<String> getChildren(String path) throws KeeperException, InterruptedException;

    int getAllChildrenNumbers(String path) throws KeeperException, InterruptedException;

    ZooKeeper.States getStat() throws KeeperException, InterruptedException;

    StatValueVO getDataNode(String path) throws KeeperException, InterruptedException;

    Stat update(String path, String data) throws KeeperException, InterruptedException;

    String save(String path, String data, CreateMode createMode) throws KeeperException, InterruptedException;

    void delete(String path) throws KeeperException, InterruptedException;
}
