package com.fc.msp.service;

import com.alibaba.fastjson.JSON;
import com.fc.msp.config.LoginInterceptor;
import com.fc.msp.dao.ZookeeperDao;
import com.fc.msp.vo.AclSetVO;
import com.fc.msp.vo.DataNode;
import com.fc.msp.vo.DataNodeVO;
import com.fc.msp.vo.StatValueVO;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ZookeeperManagerService
 * @Description Zookeeper 节点的增删改查-节点授权的新增与修改
 * @Author fangcheng
 * @Date 2020/9/12 8:58 上午
 * @Version 1.0
 */
@Component
public class ZookeeperManagerService{
    public static final String DEFAULT_SCHEME = "digest";
    @Autowired
    ZookeeperDao zkDataDAO;

    public String save(String path, String data,int createMode) throws KeeperException, InterruptedException {
        return zkDataDAO.save(path, data, CreateMode.fromFlag(createMode, CreateMode.PERSISTENT));
    }
    public void delete(String path) throws KeeperException, InterruptedException {
        zkDataDAO.delete(path);
    }
    public Stat update(String path, String data) throws KeeperException, InterruptedException {
        return zkDataDAO.update(path, data);
    }
    public String select(String path) throws KeeperException, InterruptedException {
        return zkDataDAO.getData(path);
    }
    public Stat getDataStat(String path) throws KeeperException, InterruptedException {
        return zkDataDAO.getDataStat(path);
    }
    public List<ACL> getNodeAcl(String path) throws KeeperException, InterruptedException {
        return zkDataDAO.getNodeAcl(path);
    }
    public Stat setNodeAcl(String path, String acls) throws KeeperException, InterruptedException, NoSuchAlgorithmException {
        List<ACL> aclList = new ArrayList<>();
        AclSetVO aclSet = JSON.parseObject(acls, AclSetVO.class);
        for (String aclConfig: aclSet.getAcls()) {
            String[] strings = aclConfig.split(" ");
            Id id = null;
            ACL acl = null;
            if(DEFAULT_SCHEME.equals(strings[0])){
                id = new Id(strings[0], DigestAuthenticationProvider.generateDigest(strings[1]));
                acl = new ACL(Integer.parseInt(strings[2]),id);
            } else {
                id = new Id(strings[0], DigestAuthenticationProvider.generateDigest(strings[1]));
                acl = new ACL(Integer.parseInt(strings[2]),id);
            }
            aclList.add(acl);
        }
        return zkDataDAO.setNodeAcl(path, aclList, aclSet.getVersion());
    }
    public int getAllChildrenNumbers(String path) throws KeeperException, InterruptedException {
        return zkDataDAO.getAllChildrenNumbers(path);
    }
    public List<String> getChild(String path) throws KeeperException, InterruptedException {
        return zkDataDAO.getChildren(path);
    }
    public DataNodeVO getDataNode(String path) throws KeeperException, InterruptedException {
        StatValueVO statValueVO = zkDataDAO.getDataNode(path);
        List<ACL> aclSetVO = getNodeAcl(path);
        AclSetVO aclSetVO1 = new AclSetVO(statValueVO.getStat().getVersion(), aclSetVO);
        DataNodeVO dataNode = new DataNodeVO(path,new String(statValueVO.getValue()),statValueVO.getStat(),1,aclSetVO1);
        return dataNode;
    }
    public List<DataNode> parse(List<String> nodes, String path) throws KeeperException, InterruptedException {
        List<DataNode> response = new ArrayList<>();
        for(String node: nodes){
            String id = "";
            if (!path.endsWith("/")) {
                id = path + "/" + node;
            } else {
                id = path + node;
            }
            response.add(new DataNode(id,path,LoginInterceptor.threadLocal.get(),node,"false",getChild(id).size()>0?"true":"false"));
        }
        return response;
    }
    public String move(String root, String srcPath, String targetPath, String sEnv, String tEnv) throws KeeperException, InterruptedException {
        String data = select(srcPath);
        try {
            data = select(srcPath);
        }catch (Exception e){

        }finally {
            LoginInterceptor.threadLocal.set(tEnv);
        }
        return zkDataDAO.save(srcPath,data,CreateMode.fromFlag(1,CreateMode.PERSISTENT));
    }
}
