package com.fc.msp.config;

import java.text.SimpleDateFormat;

/**
 * @ClassName ConfigurationProperties
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/29 8:20 上午
 * @Version 1.0
 */

public class ConfigurationProperties {
    public static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss:SSS");
    /**
     * 邮件相关配置
     */
    public static final String MAIL_HOST = "mail.host";
    public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
    public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    public static final String MAIL_SMTP_SSL_ENABLE = "mail.smtp.ssl.enable";
    public static final String MAIL_SMTP_SSL_SOCKET_FACTORY = "mail.smtp.ssl.socketFactory";

    /**
     * 推送相关配置
     */
    /**
     * @Description 电子邮件开关属性名称
     */
    public static final String SEND_EMAIL = "enableEmail";
    /**
     * @Description 短信服务开关属性名称
     */
    public static final String SEND_SMS = "enableSMS";
    /**
     * @Description 企业微信通知开关属性名称
     */
    public static final String SEND_WECHAT = "enableWeChat";
}
