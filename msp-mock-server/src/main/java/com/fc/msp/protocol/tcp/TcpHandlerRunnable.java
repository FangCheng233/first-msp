package com.fc.msp.protocol.tcp;

import com.fc.msp.message.SerializableUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @ClassName TcpHandlerRunnable
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/21 10:41 下午
 * @Version 1.0
 */
@Slf4j
public class TcpHandlerRunnable implements Runnable{
    private ServerSocketChannel serverSocketChannel;

    public TcpHandlerRunnable(ServerSocketChannel serverSocketChannel) throws IOException{
        this.serverSocketChannel = serverSocketChannel;
    }

    @Override
    public void run() {
        try {
            execute(serverSocketChannel);
        }catch (IOException e){
            log.info(e.getMessage());
        }
    }
    private static void execute(ServerSocketChannel serverSocketChannel) throws IOException {
        SocketChannel socketChannel = null;
        try {
            socketChannel = serverSocketChannel.accept();
            String myRequestObject = receiveData(socketChannel);
            if(log.isInfoEnabled()){
                log.info(myRequestObject);
            }
            // 创建响应数据

            sendData(socketChannel, "myResponseObject");
            if(log.isInfoEnabled()){
                log.info("发送数据完成");
            };
        } finally {
            try {
                socketChannel.close();
            } catch(Exception ex) {}
        }

    }
    private static String receiveData(SocketChannel socketChannel) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String res = null;
        try {
            byte[] bytes;
            int size = 0;
            while ((size = socketChannel.read(buffer)) >= 0) {
                buffer.flip();
                bytes = new byte[size];
                buffer.get(bytes);
                baos.write(bytes);
                buffer.clear();
            }
            bytes = baos.toByteArray();
            Object obj = SerializableUtil.toObject(bytes);
            res = obj.toString();
        } finally {
            try {
                baos.close();
            } catch(Exception ex) {}
        }
        return res;
    }
    private static void sendData(SocketChannel socketChannel, String myResponseObject) throws IOException {
        byte[] bytes = SerializableUtil.toBytes(myResponseObject);
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        socketChannel.write(buffer);
    }
}
