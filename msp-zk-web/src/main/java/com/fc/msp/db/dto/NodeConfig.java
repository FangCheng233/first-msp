package com.fc.msp.db.dto;

import java.io.Serializable;

public class NodeConfig implements Serializable {
    /**
     * @Description
     */
    private String id;
    /**
     * @Description
     */
    private String ip;

    /**
     * @Description 集群环境
     */
    private String env;
    /**
     * @Description 节点版本
     */
    private String version;
    /**
     * @Description 节点状态
     */
    private String mode;
    /**
     * @Description
     */
    private String osName;
    /**
     * @Description
     */
    private String osArch;
    /**
     * @Description
     */
    private String osVersion;
    /**
     * @Description
     */
    private String userDir;


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
     * Gets the value of ip. *
     *
     * @return the value of ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Sets the ip. *
     * <p>You can use getIp() to get the value of ip</p>
     * * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip;
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

    /**
     * Gets the value of version. *
     *
     * @return the value of version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the version. *
     * <p>You can use getVersion() to get the value of version</p>
     * * @param version version
     */
    public void setVersion(String version) {
        this.version = version;
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
     * Gets the value of osName. *
     *
     * @return the value of osName
     */
    public String getOsName() {
        return osName;
    }

    /**
     * Sets the osName. *
     * <p>You can use getOsName() to get the value of osName</p>
     * * @param osName osName
     */
    public void setOsName(String osName) {
        this.osName = osName;
    }

    /**
     * Gets the value of osArch. *
     *
     * @return the value of osArch
     */
    public String getOsArch() {
        return osArch;
    }

    /**
     * Sets the osArch. *
     * <p>You can use getOsArch() to get the value of osArch</p>
     * * @param osArch osArch
     */
    public void setOsArch(String osArch) {
        this.osArch = osArch;
    }

    /**
     * Gets the value of osVersion. *
     *
     * @return the value of osVersion
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * Sets the osVersion. *
     * <p>You can use getOsVersion() to get the value of osVersion</p>
     * * @param osVersion osVersion
     */
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    /**
     * Gets the value of userDir. *
     *
     * @return the value of userDir
     */
    public String getUserDir() {
        return userDir;
    }

    /**
     * Sets the userDir. *
     * <p>You can use getUserDir() to get the value of userDir</p>
     * * @param userDir userDir
     */
    public void setUserDir(String userDir) {
        this.userDir = userDir;
    }

    @Override
    public String toString() {
        return "NodeConfig{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", env='" + env + '\'' +
                ", version='" + version + '\'' +
                ", mode='" + mode + '\'' +
                ", osName='" + osName + '\'' +
                ", osArch='" + osArch + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", userDir='" + userDir + '\'' +
                '}';
    }
}