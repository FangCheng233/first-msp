package com.fc.msp.mspmail.mq;

import com.fc.msp.mspmail.config.UserConfig;
import com.fc.msp.mspmail.send.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName DirectReceiver
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/29 4:54 下午
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiver {
    @Autowired
    MailService mailService;

    @Autowired
    UserConfig userConfig;

    @RabbitHandler
    public void process(Map message) {
        for (Map.Entry<String,String> entry: userConfig.getUserList().entrySet()){
            mailService.send("应用系统告警",entry.getValue(),message.toString());
        }
    }

}
