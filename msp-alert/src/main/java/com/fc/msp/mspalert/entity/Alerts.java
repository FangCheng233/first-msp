package com.fc.msp.mspalert.entity;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * @ClassName Alerts
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/27 10:30 上午
 * @Version 1.0
 */
public class Alerts {
    @Value("${receiver}")
    private String receiver;
    @Value("${status}")
    private String status;
    @Value("${alerts}")
    private List<Alert> alertList;
    private GroupLabels groupLabels;
    private CommonLabels commonLabels;
    private CommonAnnotations commonAnnotations;
    @Value("${externalURL}")
    private String externalURL;
    @Value("${version}")
    private String version;
    @Value("${groupKey}")
    private String groupKey;

    /**
     * Gets the value of receiver. *
     *
     * @return the value of receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * Gets the value of status. *
     *
     * @return the value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the value of alertList. *
     *
     * @return the value of alertList
     */
    public List<Alert> getAlertList() {
        return alertList;
    }

    /**
     * Gets the value of groupLabels. *
     *
     * @return the value of groupLabels
     */
    public GroupLabels getGroupLabels() {
        return groupLabels;
    }

    /**
     * Gets the value of commonLabels. *
     *
     * @return the value of commonLabels
     */
    public CommonLabels getCommonLabels() {
        return commonLabels;
    }

    /**
     * Gets the value of commonAnnotations. *
     *
     * @return the value of commonAnnotations
     */
    public CommonAnnotations getCommonAnnotations() {
        return commonAnnotations;
    }

    /**
     * Gets the value of externalURL. *
     *
     * @return the value of externalURL
     */
    public String getExternalURL() {
        return externalURL;
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
     * Gets the value of groupKey. *
     *
     * @return the value of groupKey
     */
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * Sets the receiver. *
     * <p>You can use getReceiver() to get the value of receiver</p>
     * * @param receiver receiver
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * Sets the status. *
     * <p>You can use getStatus() to get the value of status</p>
     * * @param status status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sets the alertList. *
     * <p>You can use getAlertList() to get the value of alertList</p>
     * * @param alertList alertList
     */
    public void setAlertList(List<Alert> alertList) {
        this.alertList = alertList;
    }

    /**
     * Sets the groupLabels. *
     * <p>You can use getGroupLabels() to get the value of groupLabels</p>
     * * @param groupLabels groupLabels
     */
    public void setGroupLabels(GroupLabels groupLabels) {
        this.groupLabels = groupLabels;
    }

    /**
     * Sets the commonLabels. *
     * <p>You can use getCommonLabels() to get the value of commonLabels</p>
     * * @param commonLabels commonLabels
     */
    public void setCommonLabels(CommonLabels commonLabels) {
        this.commonLabels = commonLabels;
    }

    /**
     * Sets the commonAnnotations. *
     * <p>You can use getCommonAnnotations() to get the value of commonAnnotations</p>
     * * @param commonAnnotations commonAnnotations
     */
    public void setCommonAnnotations(CommonAnnotations commonAnnotations) {
        this.commonAnnotations = commonAnnotations;
    }

    /**
     * Sets the externalURL. *
     * <p>You can use getExternalURL() to get the value of externalURL</p>
     * * @param externalURL externalURL
     */
    public void setExternalURL(String externalURL) {
        this.externalURL = externalURL;
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
     * Sets the groupKey. *
     * <p>You can use getGroupKey() to get the value of groupKey</p>
     * * @param groupKey groupKey
     */
    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    @Override
    public String toString() {
        return "Alerts{" +
                "receiver='" + receiver + '\'' +
                ", status='" + status + '\'' +
                ", alertList=" + alertList +
                ", groupLabels=" + groupLabels +
                ", commonLabels=" + commonLabels +
                ", commonAnnotations=" + commonAnnotations +
                ", externalURL='" + externalURL + '\'' +
                ", version='" + version + '\'' +
                ", groupKey='" + groupKey + '\'' +
                '}';
    }
}
