package com.fc.msp.protocol.tcp;

import com.fc.msp.config.apolloconfig.MockConfig;

/**
 * @ClassName TcpServerStarter
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/22 8:21 下午
 * @Version 1.0
 */
public class TcpServerStarter implements Runnable{
    private MockConfig mockConfig;

    public TcpServerStarter(MockConfig mockConfig) {
        this.mockConfig = mockConfig;
    }

    @Override
    public void run() {
        TcpServerService.getInstance().startNetty(mockConfig.getPort());
    }
}
