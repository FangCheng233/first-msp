package com.fc.msp.msplogger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName Message
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/4 1:33 下午
 * @Version 1.0
 */
@Component
public class Message {
    @Value("${apolloConfig:123}")
    private String message;

    /**
     * Gets the value of message. *
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message. *
     * <p>You can use getMessage() to get the value of message</p>
     * * @param message message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
