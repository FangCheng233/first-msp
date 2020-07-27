package com.fc.msp.mspalert.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName Annotations
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/27 10:39 上午
 * @Version 1.0
 */
public class Annotations {
    @Value("${description}")
    private String description;
    @Value("${summary}")
    private String summary;

    /**
     * Gets the value of description. *
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the value of summary. *
     *
     * @return the value of summary
     */
    public String getSummary() {
        return summary;
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
     * Sets the summary. *
     * <p>You can use getSummary() to get the value of summary</p>
     * * @param summary summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }
}
