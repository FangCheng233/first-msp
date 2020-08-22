package com.fc.msp.protocol.tcp;

import com.fc.msp.config.ApplicationContextHelper;
import com.fc.msp.service.impl.TcpProcessService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName TCPSourceHandler
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/21 10:03 上午
 * @Version 1.0
 */
@Slf4j
@Component
public class TcpReceiveHandler extends ChannelInboundHandlerAdapter {
    /**
     * 本方法用于读取客户端发送的信息
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        TcpProcessService.getTcpProcessService().handleRequest(ctx, msg);
    }

    /**
     * 本方法用作处理异常
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 信息获取完毕后操作
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

}
