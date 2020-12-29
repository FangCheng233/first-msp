package com.fc.msp.notify.email;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName SendMessage
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/29 3:18 下午
 * @Version 1.0
 */
@Component
public class SendMessage {

    /**
     * @Description 使用RabbitTemplate,这提供了接收/发送等等方法
     */
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value(value = "${routingKey:TestDirectRouting}")
    private String routingKey;
    @Value(value = "${exchange:TestDirectExchange}")
    private String exchange;

    public String sendDirectMessage(String msg) {
        String messageId = String.valueOf(UUID.randomUUID());
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",msg);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend(exchange, routingKey, map);
        return "ok";
    }

}
