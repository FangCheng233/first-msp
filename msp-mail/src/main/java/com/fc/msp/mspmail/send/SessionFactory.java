package com.fc.msp.mspmail.send;

import com.fc.msp.mspmail.config.UserConfig;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @ClassName SessionFactory
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/29 12:39 下午
 * @Version 1.0
 */
@Component
public class SessionFactory {

    private static Properties properties = new Properties();
    @Autowired
    private UserConfig userConfig;

    public SessionFactory() {
        //创建一个配置文件并保存
        properties.setProperty("mail.host","smtp.qq.com");

        properties.setProperty("mail.transport.protocol","smtp");

        properties.setProperty("mail.smtp.auth","true");

        try {
            //QQ存在一个特性设置SSL加密
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
        }catch (GeneralSecurityException e){

        }
    }

    public Session getSession(){
        //创建一个session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userConfig.getUser(),userConfig.getPassword());
            }
        });
        //开启debug模式
        session.setDebug(true);
        return session;
    }
}
