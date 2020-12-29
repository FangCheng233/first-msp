package com.fc.msp.vo;

import org.apache.zookeeper.data.Stat;

import java.io.Serializable;

/**
 * @ClassName DataNode
 * @Description 每个节点存储的数据信息-包含数据-子节点-stat
 * @Author fangcheng
 * @Date 2020/9/12 8:22 上午
 * @Version 1.0
 */
public class DataNodeVO implements Serializable {
    private String id;
    private String value;
    private Stat stat;
    private int childrenNum;
    private AclSetVO aclSet;

    public DataNodeVO(String id, String value, Stat stat, int childrenNum, AclSetVO aclSet) {
        this.id = id;
        this.value = value;
        this.stat = stat;
        this.childrenNum = childrenNum;
        this.aclSet = aclSet;
    }

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
     * Gets the value of value. *
     *
     * @return the value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value. *
     * <p>You can use getValue() to get the value of value</p>
     * * @param value value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of stat. *
     *
     * @return the value of stat
     */
    public Stat getStat() {
        return stat;
    }

    /**
     * Sets the stat. *
     * <p>You can use getStat() to get the value of stat</p>
     * * @param stat stat
     */
    public void setStat(Stat stat) {
        this.stat = stat;
    }

    /**
     * Gets the value of aclSet. *
     *
     * @return the value of aclSet
     */
    public AclSetVO getAclSet() {
        return aclSet;
    }

    /**
     * Sets the aclSet. *
     * <p>You can use getAclSet() to get the value of aclSet</p>
     * * @param aclSet aclSet
     */
    public void setAclSet(AclSetVO aclSet) {
        this.aclSet = aclSet;
    }

    /**
     * Gets the value of childrenNum. *
     *
     * @return the value of childrenNum
     */
    public int getChildrenNum() {
        return childrenNum;
    }

    /**
     * Sets the childrenNum. *
     * <p>You can use getChildrenNum() to get the value of childrenNum</p>
     * * @param childrenNum childrenNum
     */
    public void setChildrenNum(int childrenNum) {
        this.childrenNum = childrenNum;
    }

    @Override
    public String toString() {
        return "DataNode{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", stat=" + stat +
                ", childrenNum=" + childrenNum +
                ", aclSet=" + aclSet +
                '}';
    }
}
