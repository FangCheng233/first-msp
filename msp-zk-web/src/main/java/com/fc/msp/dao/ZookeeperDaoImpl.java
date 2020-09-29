package com.fc.msp.dao;

import com.fc.msp.vo.StatValueVO;
import com.fc.msp.zkclient.ZKClientFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ZookeeperDaoImpl
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/14 11:58 上午
 * @Version 1.0
 * */


@Slf4j
@Component
public class ZookeeperDaoImpl implements ZookeeperDao{

    @Autowired
    private ZKClientFactory zkClientFactory;

    @Override
    public String getData(String path) throws KeeperException, InterruptedException {
        byte[] data = zkClientFactory.getClient().getData(path, false, new Stat());
        zkClientFactory.getClient().getData("/", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        },null,null);
        return new String(data);
    }

    @Override
    public Stat getDataStat(String path) throws KeeperException, InterruptedException {
        Stat stat = new Stat();
        zkClientFactory.getClient().getData(path, false, stat);
        zkClientFactory.getClient().getEphemerals(path);
        return stat;
    }
    @Override
    public StatValueVO getDataNode(String path) throws KeeperException, InterruptedException {
        Stat stat = new Stat();
        return new StatValueVO(zkClientFactory.getClient().getData(path, false, stat),stat);
    }
    @Override
    public List<ACL> getNodeAcl(String path) throws KeeperException, InterruptedException {
        return zkClientFactory.getClient().getACL(path, new Stat());
    }

    @Override
    public Stat setNodeAcl(String path, List<ACL> acl, int version) throws KeeperException, InterruptedException {
        return zkClientFactory.getClient().setACL(path, acl, version);
    }

    @Override
    public List<String> getChildren(String path) {
        List<String> children = new ArrayList<>();
        try {
            children = zkClientFactory.getClient().getChildren(path, false);
        }catch (KeeperException keeperException){
            log.warn("");
        }catch (InterruptedException interruptedException){
            log.warn("");
        }
        return children;
    }
    @Override
    public ZooKeeper.States getStat() throws KeeperException, InterruptedException {
        ZooKeeper.States state = zkClientFactory.getClient().getState();
        return state;
    }

    @Override
    public int getAllChildrenNumbers(String path) throws KeeperException, InterruptedException {
        return zkClientFactory.getClient().getAllChildrenNumber(path);
    }

    @Override
    public Stat update(String path, String data) throws KeeperException, InterruptedException{
        Stat stat = zkClientFactory.getClient().setData(path, data.getBytes(), 0);
        log.info("数据插入成功{}", stat.getVersion());
        return stat;
    }
/**
     *
     * @Description
     * @Author fangcheng
     * @param path :
     * @param data :
     * @return java.lang.String
     * @throws
     * @Date 2020/9/14 12:15 上午
 * */


    @Override
    public String save(String path, String data, CreateMode createMode) throws KeeperException, InterruptedException {

        String value = zkClientFactory.getClient().create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, createMode);
        log.info("{}", value);
        return value;
    }
    @Override
    public void delete(String path) throws KeeperException, InterruptedException {
        zkClientFactory.getClient().delete(path, 0);
    }
}
