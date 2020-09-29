package com.fc.msp.vo;

import java.io.Serializable;

/**
 * @ClassName Node
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/13 5:00 下午
 * @Version 1.0
 */
public class DataNode implements Serializable {
    private String id;
    private String pid;
    private String env;
    private String name;
    private String open;
    private String isParent;

    public DataNode(String id, String pid, String env, String name, String open, String isParent) {
        super();
        this.id = id;
        this.pid = pid;
        this.env = env;
        this.name = name;
        this.open = open;
        this.isParent = isParent;
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
     * Gets the value of pid. *
     *
     * @return the value of pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * Sets the pid. *
     * <p>You can use getPid() to get the value of pid</p>
     * * @param pid pid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * Gets the value of name. *
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name. *
     * <p>You can use getName() to get the value of name</p>
     * * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of open. *
     *
     * @return the value of open
     */
    public String getOpen() {
        return open;
    }

    /**
     * Sets the open. *
     * <p>You can use getOpen() to get the value of open</p>
     * * @param open open
     */
    public void setOpen(String open) {
        this.open = open;
    }

    /**
     * Gets the value of isParent. *
     *
     * @return the value of isParent
     */
    public String getIsParent() {
        return isParent;
    }

    /**
     * Sets the isParent. *
     * <p>You can use getIsParent() to get the value of isParent</p>
     * * @param isParent isParent
     */
    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    /**
     * Gets the value of env. *
     *
     * @return the value of env
     */
    public String getEnv() {
        return env;
    }

    /**
     * Sets the env. *
     * <p>You can use getEnv() to get the value of env</p>
     * * @param env env
     */
    public void setEnv(String env) {
        this.env = env;
    }
}
