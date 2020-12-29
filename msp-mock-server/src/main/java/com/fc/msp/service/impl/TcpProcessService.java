package com.fc.msp.service.impl;

import com.fc.msp.config.apolloconfig.ApolloConfigurationListener;
import com.fc.msp.message.TcpResponseMessage;
import com.fc.msp.service.interfaces.IService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;

/**
 * @ClassName TcpProcessService
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/22 6:24 下午
 * @Version 1.0
 */
@Slf4j
@Component
public class TcpProcessService implements IService {
    @Autowired
    private TcpResponseMessage tcpResponseMessage;

    public void handleRequest(ChannelHandlerContext ctx, Object msg){
        log.info("————————————接收到新的消息开始处理————————————");
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        // msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中
        result.readBytes(result1);
        String resultStr = new String(result1);
        // 接收并打印客户端的信息
        log.info("Client said:" + resultStr);
        // 释放资源，这行很关键
        result.release();
        // 向客户端发送消息

        int port = ((InetSocketAddress)ctx.channel().localAddress()).getPort();
        //获取数据文件的key
        String messageId = ApolloConfigurationListener.getTcpMsgs().get(port);
        String response = new TcpResponseMessage().createMessage(messageId);
        // 在当前场景下，发送的数据必须转换成ByteBuf数组
        log.info("响应的消息为{}", response);
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }
    private static volatile TcpProcessService tcpProcessService;

    /**
     * Gets the value of tcpProcessService. *
     *
     * @return the value of tcpProcessService
     */
    public static TcpProcessService getTcpProcessService() {
        if (tcpProcessService == null){
            synchronized (TcpProcessService.class){
                if(tcpProcessService == null){
                    tcpProcessService = new TcpProcessService();
                }
            }
        }
        return tcpProcessService;
    }
}
