package com.fc.msp.protocol.http;

import com.fc.msp.config.apolloconfig.MockConfig;
import com.fc.msp.config.threadpool.ThreadPoolManager;
import com.fc.msp.service.impl.HttpProcessService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName HttpHandler
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/21 2:56 下午
 * @Version 1.0
 */
@Slf4j
public class HttpReceiveHandler extends AbstractHandler {
    private MockConfig mockConfig;

    public HttpReceiveHandler(MockConfig mockConfig) {
        this.mockConfig = mockConfig;
    }

    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws IOException, ServletException {
        new HttpProcessService().handlerRequest(request,mockConfig,httpServletResponse);
    }

}
