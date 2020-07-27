package com.fc.msp.mspalert.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName CommonLabels
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/27 10:33 上午
 * @Version 1.0
 */
public class CommonLabels {
    @Value("${alertname}")
    private String alertname;
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
