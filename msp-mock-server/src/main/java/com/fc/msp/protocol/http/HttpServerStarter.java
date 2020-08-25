package com.fc.msp.protocol.http;

import com.fc.msp.config.apolloconfig.MockConfig;
import com.fc.msp.service.impl.HttpProcessService;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName HandleRequest
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/22 8:55 下午
 * @Version 1.0
 */
@Slf4j
public class HttpServerStarter implements Runnable {

    private MockConfig mockConfig;

    public HttpServerStarter(MockConfig mockConfig) {
        this.mockConfig = mockConfig;
    }

    @Override
    public void run() {
        log.info("HttpServerStarter" + Thread.currentThread().getName());
        Thread.currentThread().setName("Http-Thread-" + mockConfig.getName());
        new HttpServerService(mockConfig).startJetty();
    }
}
