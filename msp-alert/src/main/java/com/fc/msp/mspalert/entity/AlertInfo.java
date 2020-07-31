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
    @Column(name = "ALERT_NAME")
    private String alertName;

    /**
     * @Description
     */
    @Column(name = "SYSTEM")
    private String system;

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
    private String alertMsgId;

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


}
