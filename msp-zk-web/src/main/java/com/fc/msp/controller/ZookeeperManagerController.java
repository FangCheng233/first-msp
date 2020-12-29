package com.fc.msp.controller;

import com.fc.msp.vo.DataNodeVO;
import com.fc.msp.vo.DataNode;
import com.fc.msp.service.ZookeeperManagerService;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @ClassName ZookeeperManagerController
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/12 8:56 上午
 * @Version 1.0
 */
@Controller
@RequestMapping("/api")
public class ZookeeperManagerController {
    @Autowired
    ZookeeperManagerService zookeeperManagerService;
    /**
     *
     * @Description
     * @Author fangcheng
     * @param path :
     * @return java.util.List<com.fc.msp.response.Node>
     * @throws
     * @Date 2020/9/14 10:37 下午
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public List<DataNode> getNodes(String path) throws KeeperException, InterruptedException{
        if (path == null) {
            return null;
        }
        List<String> nodes = zookeeperManagerService.getChild(path);
        return zookeeperManagerService.parse(nodes, path);
    }
    /**
     *
     * @Description
     * @Author fangcheng
     * @param path :
     * @return java.lang.String
     * @throws
     * @Date 2020/9/14 10:37 下午
     */
    @GetMapping(value = "/getData")
    public String getNodeData(String path) throws KeeperException, InterruptedException{
        if (path == null) {
            return null;
        }
        return zookeeperManagerService.select(path);
    }
    /**
     *
     * @Description
     * @Author fangcheng
     * @param path :
     * @return java.lang.String
     * @throws
     * @Date 2020/9/14 10:37 下午
     */
    @GetMapping(value = "/getNode")
    @ResponseBody
    public DataNodeVO getNode(String path) throws KeeperException, InterruptedException{
        if (path == null) {
            return null;
        }
        return zookeeperManagerService.getDataNode(path);
    }
    /**
     *
     * @Description
     * @Author fangcheng
     * @param path :
     * @return org.apache.zookeeper.data.Stat
     * @throws
     * @Date 2020/9/14 10:37 下午
     */
    @GetMapping(value = "/getStat")
    @ResponseBody
    public Stat getNodeStat(String path) throws KeeperException, InterruptedException{
        if (path == null) {
            return null;
        }
        return zookeeperManagerService.getDataStat(path);
    }
    /**
     *
     * @Description
     * @Author fangcheng
     * @param path :
     * @return java.util.List<org.apache.zookeeper.data.ACL>
     * @throws
     * @Date 2020/9/14 10:36 下午
     */
    @GetMapping(value = "/getAcl")
    @ResponseBody
    public List<ACL> getNodeACL(String path) throws KeeperException, InterruptedException{
        if (path == null) {
            return null;
        }
        return zookeeperManagerService.getNodeAcl(path);
    }
    /**
     *
     * @Description
     * @Author fangcheng
     * @param path :
     * @param acl :
     * @return java.util.List<org.apache.zookeeper.data.ACL>
     * @throws
     * @Date 2020/9/14 10:37 下午
     */
    @PostMapping(value = "/setAcl")
    public Stat setNodeACL(String path, String acl) throws KeeperException, InterruptedException, NoSuchAlgorithmException {
        if (path == null) {
            return null;
        }
        return zookeeperManagerService.setNodeAcl(path, acl);
    }
    /**
     *
     * @Description
     * @Author fangcheng
     * @param path :
     * @return java.lang.Integer
     * @throws
     * @Date 2020/9/14 10:38 下午
     */
    @GetMapping(value = "/getNum")
    public Integer getNodeNumbers(String path) throws KeeperException, InterruptedException{
        if (path == null) {
            return null;
        }
        return zookeeperManagerService.getAllChildrenNumbers(path);
    }

    /**
     *
     * @Description
     * @Author fangcheng
     * @param path :
     * @param value :
     * @param mode :
     * @return java.lang.String
     * @throws
     * @Date 2020/9/14 10:38 下午
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public String addNodes(String path,String value, int mode) throws KeeperException, InterruptedException{
        if (path == null) {
            return null;
        }
        return zookeeperManagerService.save(path, value, mode);
    }
    @PostMapping(value = "/move")
    @ResponseBody
    public String moveNodes(String root, String srcPath, String targetPath, String sEnv, String tEnv) throws KeeperException, InterruptedException{
        if (root == null || srcPath == null || targetPath == null|| sEnv == null || targetPath == null) {
            return null;
        }
        return zookeeperManagerService.move(root, srcPath, targetPath, sEnv, tEnv);
    }
}
