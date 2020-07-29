package com.fc.msp.mspalert.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String ID;
    /**
     * @Description
     */
    @Column
    private String status;
    /**
     * @Description
     */
    @Column(name = "ALERT_MSG")
    private String alertMsg;

    /**
     * Gets the value of ID. *
     *
     * @return the value of ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the ID. *
     * <p>You can use getID() to get the value of ID</p>
     * * @param ID ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Gets the value of alertMsg. *
     *
     * @return the value of alertMsg
     */
    public String getAlertMsg() {
        return alertMsg;
    }

    /**
     * Sets the alertMsg. *
     * <p>You can use getAlertMsg() to get the value of alertMsg</p>
     * * @param alertMsg alertMsg
     */
    public void setAlertMsg(String alertMsg) {
        this.alertMsg = alertMsg;
    }

    @Override
    public String toString() {
        return "AlertInfo{" +
                "ID='" + ID + '\'' +
                ", alertMsg='" + alertMsg + '\'' +
                '}';
    }
}
