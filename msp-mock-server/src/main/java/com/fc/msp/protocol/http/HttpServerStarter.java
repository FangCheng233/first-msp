package com.fc.msp.protocol.http;

import com.fc.msp.service.impl.HttpProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName HandleRequest
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/22 8:55 下午
 * @Version 1.0
 */

public class HttpServerStarter implements Runnable {

    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;

    public HttpServerStarter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
    }

    @Override
    public void run() {
        HttpProcessService.getHttpProcessService().handlerRequest(httpServletRequest, httpServletResponse);
    }
}
