package com.fc.msp.mspalert.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @version 1.0.0
 * @description:
 * @author: FangCheng
 * @time: 2020/7/27 10:25
 */

public class Alert {
    @Value("${status}")
    private String status;
    @Value("${annotations}")
    private Annotations annotations;
    @Value("${startsAt}")
    private String startsAt;
    @Value("${endsAt}")
    private String endsAt;
    @Value("${generatorURL}")
    private String generatorURL;

    /**
     * Gets the value of status. *
     *
     * @return the value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the value of annotations. *
     *
     * @return the value of annotations
     */
    public Annotations getAnnotations() {
        return annotations;
    }

    /**
     * Gets the value of startsAt. *
     *
     * @return the value of startsAt
     */
    public String getStartsAt() {
        return startsAt;
    }

    /**
     * Gets the value of endsAt. *
     *
     * @return the value of endsAt
     */
    public String getEndsAt() {
        return endsAt;
    }

    /**
     * Gets the value of generatorURL. *
     *
     * @return the value of generatorURL
     */
    public String getGeneratorURL() {
        return generatorURL;
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
     * Sets the annotations. *
     * <p>You can use getAnnotations() to get the value of annotations</p>
     * * @param annotations annotations
     */
    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }

    /**
     * Sets the startsAt. *
     * <p>You can use getStartsAt() to get the value of startsAt</p>
     * * @param startsAt startsAt
     */
    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    /**
     * Sets the endsAt. *
     * <p>You can use getEndsAt() to get the value of endsAt</p>
     * * @param endsAt endsAt
     */
    public void setEndsAt(String endsAt) {
        this.endsAt = endsAt;
    }

    /**
     * Sets the generatorURL. *
     * <p>You can use getGeneratorURL() to get the value of generatorURL</p>
     * * @param generatorURL generatorURL
     */
    public void setGeneratorURL(String generatorURL) {
        this.generatorURL = generatorURL;
    }
}
