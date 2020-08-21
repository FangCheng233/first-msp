package com.fc.msp.service;

import com.fc.msp.protocol.http.HttpHandlerRunnable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MockService
 * @Description TODO  实现具体对http请求的处理
 * @Author fangcheng
 * @Date 2020/8/21 11:09 上午
 * @Version 1.0
 */
@Slf4j
@Component
public class MockService {
    public void handlerRequest(HttpServletRequest request, HttpServletResponse response){
        new HttpHandlerRunnable(request, response).run();
    }

}
