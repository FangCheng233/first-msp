package com.fc.msp.mspalert.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @version 1.0.0
 * @description:
 * @author: FangCheng
 * @time: 2020/7/27 10:25
 */

public class Labels {
    @Value("${alertname}")
    private String alertname;
    @Value("${instance}")
    private String instance;
    @Value("${job}")
    private String job;
    @Value("${severity}")
    private String severity;

    /**
     * Gets the value of alertname. *
     *
     * @return the value of alertname
     */
    public String getAlertname() {
        return alertname;
    }

    /**
     * Gets the value of instance. *
     *
     * @return the value of instance
     */
    public String getInstance() {
        return instance;
    }

    /**
     * Gets the value of job. *
     *
     * @return the value of job
     */
    public String getJob() {
        return job;
    }

    /**
     * Gets the value of severity. *
     *
     * @return the value of severity
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * Sets the alertname. *
     * <p>You can use getAlertname() to get the value of alertname</p>
     * * @param alertname alertname
     */
    public void setAlertname(String alertname) {
        this.alertname = alertname;
    }

    /**
     * Sets the instance. *
     * <p>You can use getInstance() to get the value of instance</p>
     * * @param instance instance
     */
    public void setInstance(String instance) {
        this.instance = instance;
    }

    /**
     * Sets the job. *
     * <p>You can use getJob() to get the value of job</p>
     * * @param job job
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * Sets the severity. *
     * <p>You can use getSeverity() to get the value of severity</p>
     * * @param severity severity
     */
    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
