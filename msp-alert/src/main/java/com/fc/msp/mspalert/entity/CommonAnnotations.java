package com.fc.msp.mspalert.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName CommonAnnotations
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/27 10:35 上午
 * @Version 1.0
 */
public class CommonAnnotations {
    @Value("${description}")
    private String description;

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
}
