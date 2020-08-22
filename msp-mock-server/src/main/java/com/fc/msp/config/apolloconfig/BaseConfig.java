package com.fc.msp.config.apolloconfig;

import java.io.Serializable;

/**
 * @ClassName BaseConfig
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/21 9:03 下午
 * @Version 1.0
 */
public class BaseConfig implements Serializable {
    /**
     * @Description
     */
    private String type;
    /**
     * @Description
     */
    private String responseMsg;

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
     * Gets the value of responseMsg. *
     *
     * @return the value of responseMsg
     */
    public String getResponseMsg() {
        return responseMsg;
    }

    /**
     * Sets the responseMsg. *
     * <p>You can use getResponseMsg() to get the value of responseMsg</p>
     * * @param responseMsg responseMsg
     */
    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
