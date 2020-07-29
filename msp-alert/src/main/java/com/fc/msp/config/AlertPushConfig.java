package com.fc.msp.config;

import org.springframework.stereotype.Component;

/**
 * @ClassName AlertPushConfig
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/29 10:06 上午
 * @Version 1.0
 */
@Component
public class AlertPushConfig {
    private String enableEmail;
    private String enableSMS;
    private String enableWeChat;

    /**
     * Gets the value of enableEmail. *
     *
     * @return the value of enableEmail
     */
    public String getEnableEmail() {
        return enableEmail;
    }

    /**
     * Sets the enableEmail. *
     * <p>You can use getEnableEmail() to get the value of enableEmail</p>
     * * @param enableEmail enableEmail
     */
    public void setEnableEmail(String enableEmail) {
        this.enableEmail = enableEmail;
    }

    /**
     * Gets the value of enableSMS. *
     *
     * @return the value of enableSMS
     */
    public String getEnableSMS() {
        return enableSMS;
    }

    /**
     * Sets the enableSMS. *
     * <p>You can use getEnableSMS() to get the value of enableSMS</p>
     * * @param enableSMS enableSMS
     */
    public void setEnableSMS(String enableSMS) {
        this.enableSMS = enableSMS;
    }

    /**
     * Gets the value of enableWeChat. *
     *
     * @return the value of enableWeChat
     */
    public String getEnableWeChat() {
        return enableWeChat;
    }

    /**
     * Sets the enableWeChat. *
     * <p>You can use getEnableWeChat() to get the value of enableWeChat</p>
     * * @param enableWeChat enableWeChat
     */
    public void setEnableWeChat(String enableWeChat) {
        this.enableWeChat = enableWeChat;
    }
}