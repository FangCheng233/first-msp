package com.fc.msp.mspalert.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0.0
 * @description:
 * @author: FangCheng
 * @time: 2020/7/28 18:04
 */
@Table(name="ALERT_INFO")
public class AlertInfo implements Serializable {
    private static final long serialVersionUID = 1435521231412243545L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    /**
     * @Description
     */
    @Column(name = "ALERT_NAME")
    private String alertName;

    /**
     * @Description
     */
    @Column(name = "SYSTEM_ID")
    private String systemId;

    /**
     * @Description
     */
    @Column(name = "DESCRIPTION")
    private String description;
    /**
     * @Description
     */
    @Column(name = "STATUS")
    private String status;
    /**
     * @Description
     */
    @Column(name = "ALERT_MSG_ID")
    private Integer alertMsgId;

    /**
     * @Description
     */
    @Column(name = "CREATE_TIME")
    private String createTime;

    /**
     * Gets the value of ID. *
     *
     * @return the value of ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID. *
     * <p>You can use getID() to get the value of ID</p>
     * * @param ID ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the value of alertName. *
     *
     * @return the value of alertName
     */
    public String getAlertName() {
        return alertName;
    }

    /**
     * Sets the alertName. *
     * <p>You can use getAlertName() to get the value of alertName</p>
     * * @param alertName alertName
     */
    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }

    /**
     * Gets the value of system. *
     *
     * @return the value of system
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * Sets the system. *
     * <p>You can use getSystem() to get the value of system</p>
     * * @param system system
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    /**
     * Gets the value of description. *
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description. *
     * <p>You can use getDescription() to get the value of description</p>
     * * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Sets the status. *
     * <p>You can use getStatus() to get the value of status</p>
     * * @param status status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the value of alertMsgId. *
     *
     * @return the value of alertMsgId
     */
    public Integer getAlertMsgId() {
        return alertMsgId;
    }

    /**
     * Sets the alertMsgId. *
     * <p>You can use getAlertMsgId() to get the value of alertMsgId</p>
     * * @param alertMsgId alertMsgId
     */
    public void setAlertMsgId(Integer alertMsgId) {
        this.alertMsgId = alertMsgId;
    }

    /**
     * Gets the value of createTime. *
     *
     * @return the value of createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Sets the createTime. *
     * <p>You can use getCreateTime() to get the value of createTime</p>
     * * @param createTime createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AlertInfo{" +
                "id='" + id + '\'' +
                ", alertName='" + alertName + '\'' +
                ", systemId='" + systemId + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", alertMsgId='" + alertMsgId + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
