package com.fc.msp.mspmail.send;

import com.fc.msp.mspmail.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @ClassName MailService
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/29 12:46 下午
 * @Version 1.0
 */
@Component
public class MailService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserConfig userConfig;
    /**
     *
     * @Description
     * @Author fangcheng
     * @param title :
     * @param address :
     * @param message :
     * @return void
     * @throws
     * @Date 2020/7/29 12:52 下午
     */
    public void send(String title, String address, String message) {
        Session session = sessionFactory.getSession();

        Transport transport = null;
        try {
            //获取连接对象
            transport = session.getTransport();
            //连接服务器
            transport.connect("smtp.qq.com",userConfig.getUser(),userConfig.getPassword());
            System.out.println("user" + userConfig.getUser());
            //创建邮件对象
            MimeMessage mimeMessage = new MimeMessage(session);

            //邮件发送人
            mimeMessage.setFrom(new InternetAddress(userConfig.getUser()));

            //邮件接收人
            mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(address));

            //邮件标题
            mimeMessage.setSubject(title);

            //邮件内容
            mimeMessage.setContent(message,"text/html;charset=UTF-8");

            //发送邮件
            transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        }catch (MessagingException e){

        }finally{
            //关闭连接
            if(transport != null){
                try {
                    transport.close();
                }catch (MessagingException e){

                }
            }
        }
    }
}
