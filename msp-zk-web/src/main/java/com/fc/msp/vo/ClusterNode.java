package com.fc.msp.vo;

import java.io.Serializable;

/**
 * @ClassName ClusterNode
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/20 4:59 下午
 * @Version 1.0
 */
public class ClusterNode implements Serializable {
    /**
     * @Description 节点名称  -IP地址
     */
    private String nodeName;
    /**
     * @Description 节点状态 正常/掉线
     */
    private int nodeStatus;
    /**
     * @Description 节点类型 follow/leader/observer
     */
    private String nodeType;

    public ClusterNode(String nodeName, int nodeStatus, String nodeType) {
        this.nodeName = nodeName;
        this.nodeStatus = nodeStatus;
        this.nodeType = nodeType;
    }

    /**
     * Gets the value of nodeName. *
     *
     * @return the value of nodeName
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * Sets the nodeName. *
     * <p>You can use getNodeName() to get the value of nodeName</p>
     * * @param nodeName nodeName
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * Gets the value of nodeStatus. *
     *
     * @return the value of nodeStatus
     */
    public int getNodeStatus() {
        return nodeStatus;
    }

    /**
     * Sets the nodeStatus. *
     * <p>You can use getNodeStatus() to get the value of nodeStatus</p>
     * * @param nodeStatus nodeStatus
     */
    public void setNodeStatus(int nodeStatus) {
        this.nodeStatus = nodeStatus;
    }

    /**
     * Gets the value of nodeType. *
     *
     * @return the value of nodeType
     */
    public String getNodeType() {
        return nodeType;
    }

    /**
     * Sets the nodeType. *
     * <p>You can use getNodeType() to get the value of nodeType</p>
     * * @param nodeType nodeType
     */
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    @Override
    public String toString() {
        return "ClusterNode{" +
                "nodeName='" + nodeName + '\'' +
                ", nodeStatus='" + nodeStatus + '\'' +
                ", nodeType='" + nodeType + '\'' +
                '}';
    }
}
