package com.fc.msp.protocol.tcp;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * @ClassName TCPSourceHandler
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/21 10:03 上午
 * @Version 1.0
 */
@Slf4j
public class TCPSourceHandler {
    public static void createServerSocket(int port) throws IOException {
        ServerSocketChannel serverSocketChannel;
        Selector selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        if (log.isDebugEnabled()) {
            log.debug("Start TCP server on port " + port
                    + ((serverSocketChannel != null) ? " sucessfully!" : " failed!"));
        }
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey readyKey = it.next();
                it.remove();
                new TcpHandlerRunnable((ServerSocketChannel) readyKey.channel());
            }
        }
    }



}
