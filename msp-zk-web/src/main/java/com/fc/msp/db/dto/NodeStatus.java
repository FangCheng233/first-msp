package com.fc.msp.db.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName NodeStatus
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/20 10:24 下午
 * @Version 1.0
 */
public class NodeStatus implements Serializable {
    private String id;
    /**
     * @Description nodeConfig 主键
     */
    private String nodeIp;
    /**
     * @Description
     */
    private int connections;
    private int received;
    private int sent;
    private int outStanding;
    private String mode;
    private int nodeCount;
    private String osMemoryFree;
    private String osMemoryMax;
    private String osMemoryTotal;
    private Date date;

    /**
     * Gets the value of id. *
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id. *
     * <p>You can use getId() to get the value of id</p>
     * * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the value of nodeIp. *
     *
     * @return the value of nodeIp
     */
    public String getNodeIp() {
        return nodeIp;
    }

    /**
     * Sets the nodeIp. *
     * <p>You can use getNodeIp() to get the value of nodeIp</p>
     * * @param nodeIp nodeIp
     */
    public void setNodeIp(String nodeIp) {
        this.nodeIp = nodeIp;
    }

    /**
     * Gets the value of connections. *
     *
     * @return the value of connections
     */
    public int getConnections() {
        return connections;
    }

    /**
     * Sets the connections. *
     * <p>You can use getConnections() to get the value of connections</p>
     * * @param connections connections
     */
    public void setConnections(int connections) {
        this.connections = connections;
    }

    /**
     * Gets the value of received. *
     *
     * @return the value of received
     */
    public int getReceived() {
        return received;
    }

    /**
     * Sets the received. *
     * <p>You can use getReceived() to get the value of received</p>
     * * @param received received
     */
    public void setReceived(int received) {
        this.received = received;
    }

    /**
     * Gets the value of sent. *
     *
     * @return the value of sent
     */
    public int getSent() {
        return sent;
    }

    /**
     * Sets the sent. *
     * <p>You can use getSent() to get the value of sent</p>
     * * @param sent sent
     */
    public void setSent(int sent) {
        this.sent = sent;
    }

    /**
     * Gets the value of outStanding. *
     *
     * @return the value of outStanding
     */
    public int getOutStanding() {
        return outStanding;
    }

    /**
     * Sets the outStanding. *
     * <p>You can use getOutStanding() to get the value of outStanding</p>
     * * @param outStanding outStanding
     */
    public void setOutStanding(int outStanding) {
        this.outStanding = outStanding;
    }

    /**
     * Gets the value of mode. *
     *
     * @return the value of mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the mode. *
     * <p>You can use getMode() to get the value of mode</p>
     * * @param mode mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Gets the value of nodeCount. *
     *
     * @return the value of nodeCount
     */
    public int getNodeCount() {
        return nodeCount;
    }

    /**
     * Sets the nodeCount. *
     * <p>You can use getNodeCount() to get the value of nodeCount</p>
     * * @param nodeCount nodeCount
     */
    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    /**
     * Gets the value of osMemoryFree. *
     *
     * @return the value of osMemoryFree
     */
    public String getOsMemoryFree() {
        return osMemoryFree;
    }

    /**
     * Sets the osMemoryFree. *
     * <p>You can use getOsMemoryFree() to get the value of osMemoryFree</p>
     * * @param osMemoryFree osMemoryFree
     */
    public void setOsMemoryFree(String osMemoryFree) {
        this.osMemoryFree = osMemoryFree;
    }

    /**
     * Gets the value of osMemoryMax. *
     *
     * @return the value of osMemoryMax
     */
    public String getOsMemoryMax() {
        return osMemoryMax;
    }

    /**
     * Sets the osMemoryMax. *
     * <p>You can use getOsMemoryMax() to get the value of osMemoryMax</p>
     * * @param osMemoryMax osMemoryMax
     */
    public void setOsMemoryMax(String osMemoryMax) {
        this.osMemoryMax = osMemoryMax;
    }

    /**
     * Gets the value of osMemoryTotal. *
     *
     * @return the value of osMemoryTotal
     */
    public String getOsMemoryTotal() {
        return osMemoryTotal;
    }

    /**
     * Sets the osMemoryTotal. *
     * <p>You can use getOsMemoryTotal() to get the value of osMemoryTotal</p>
     * * @param osMemoryTotal osMemoryTotal
     */
    public void setOsMemoryTotal(String osMemoryTotal) {
        this.osMemoryTotal = osMemoryTotal;
    }

    /**
     * Gets the value of date. *
     *
     * @return the value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date. *
     * <p>You can use getDate() to get the value of date</p>
     * * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public NodeStatus(String nodeIp, int connections, int received, int sent, int outStanding, String mode, int nodeCount, String osMemoryFree, String osMemoryMax, String osMemoryTotal, Date date) {
        this.nodeIp = nodeIp;
        this.connections = connections;
        this.received = received;
        this.sent = sent;
        this.outStanding = outStanding;
        this.mode = mode;
        this.nodeCount = nodeCount;
        this.osMemoryFree = osMemoryFree;
        this.osMemoryMax = osMemoryMax;
        this.osMemoryTotal = osMemoryTotal;
        this.date = date;
    }

    @Override
    public String toString() {
        return "NodeStatus{" +
                "id='" + id + '\'' +
                ", nodeIp='" + nodeIp + '\'' +
                ", connections=" + connections +
                ", received=" + received +
                ", sent=" + sent +
                ", outStanding=" + outStanding +
                ", mode='" + mode + '\'' +
                ", nodeCount=" + nodeCount +
                ", osMemoryFree='" + osMemoryFree + '\'' +
                ", osMemoryMax='" + osMemoryMax + '\'' +
                ", osMemoryTotal='" + osMemoryTotal + '\'' +
                ", date=" + date +
                '}';
    }
}
