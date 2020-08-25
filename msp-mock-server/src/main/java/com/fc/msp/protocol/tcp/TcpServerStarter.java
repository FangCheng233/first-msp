package com.fc.msp.protocol.tcp;

import com.fc.msp.config.apolloconfig.MockConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName TcpServerStarter
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/22 8:21 下午
 * @Version 1.0
 */
@Slf4j
public class TcpServerStarter implements Runnable{
    private MockConfig mockConfig;

    public TcpServerStarter(MockConfig mockConfig) {
        this.mockConfig = mockConfig;
    }

    @Override
    public void run() {
        log.info("TcpServerStarter" + Thread.currentThread().getName());
        Thread.currentThread().setName("Tcp-Thread-" + mockConfig.getName());
        new TcpServerService(mockConfig).startNetty();
    }
}
