package com.fc.msp.notify.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassName Message
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/4 10:14 上午
 * @Version 1.0
 */
@Component
public class Message implements Serializable {
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
    @Value("${messagesss}")
    public void setMessage(String message) {
        this.message = message;
    }
}
