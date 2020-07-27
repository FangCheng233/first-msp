package com.fc.msp.mspalert.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName GroupLabels
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/27 10:33 上午
 * @Version 1.0
 */
public class GroupLabels {
    @Value("${alertname}")
    private String alertName;

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
}
