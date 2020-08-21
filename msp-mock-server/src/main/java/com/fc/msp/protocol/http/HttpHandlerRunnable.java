package com.fc.msp.protocol.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName HttpHandler
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/21 2:56 下午
 * @Version 1.0
 */
public class HttpHandlerRunnable implements Runnable{
    private HttpServletRequest request;
    private HttpServletResponse response;

    public HttpHandlerRunnable(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void run() {
        String url = request.getContextPath();
        String method = request.getMethod();

    }

}
