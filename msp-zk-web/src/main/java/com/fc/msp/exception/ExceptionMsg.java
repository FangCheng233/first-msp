package com.fc.msp.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @ClassName ExceptionMsg
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/15 8:39 上午
 * @Version 1.0
 */
public class ExceptionMsg implements Serializable {
    private String message;
    private String type;
    private int code;

    public ExceptionMsg(String message, String type) {
        this.message = message;
        this.type = type;
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
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

    /**
     * Gets the value of type. *
     *
     * @return the value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type. *
     * <p>You can use getType() to get the value of type</p>
     * * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the value of code. *
     *
     * @return the value of code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the code. *
     * <p>You can use getCode() to get the value of code</p>
     * * @param code code
     */
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ExceptionMsg{" +
                "message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", code=" + code +
                '}';
    }
}
