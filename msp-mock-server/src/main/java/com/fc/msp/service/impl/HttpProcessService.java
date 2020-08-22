package com.fc.msp.service.impl;

import com.fc.msp.config.apolloconfig.ApolloConfigurationListener;
import com.fc.msp.config.apolloconfig.MockConfig;
import com.fc.msp.message.HttpResponseMessage;
import com.fc.msp.service.interfaces.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * @ClassName MockService
 * @Description TODO  实现具体对http请求的处理  暂时使用线程 后续改为线程池
 * @Author fangcheng
 * @Date 2020/8/21 11:09 上午
 * @Version 1.0
 */
@Slf4j
@Component
public class HttpProcessService implements IService {
    /**
     *
     * @Description 接收过滤到的请求，根据请求路径和方法判断是否需要处理
     * @Author fangcheng
     * @param request :
     * @return void
     * @throws
     * @Date 2020/8/22 7:04 下午
     */
    public void handlerRequest(HttpServletRequest request, HttpServletResponse response){
        String method = request.getMethod();//获取请求类型
        String url = request.getServletPath();//获取请求路径
        String retMSG = "";
        log.debug("————————————接收到新的请求————————————");
        Map<String, MockConfig> mockConfigMap = ApolloConfigurationListener.getMockConfigs();
        for (MockConfig mockConfig : mockConfigMap.values()) {
            if(url.equals(mockConfig.getUrl()) && method.equals(mockConfig.getMethod())){
                retMSG = new HttpResponseMessage().createMessage(mockConfig.getResponseMsg());
                processResponse(retMSG, mockConfig, response);
            }else {
                retMSG = new HttpResponseMessage().createExceptionMessage(mockConfig.getResponseMsg());
                processResponse(retMSG, mockConfig, response);
            }
        }
    }
    public void processResponse(String msg,MockConfig mockConfig,HttpServletResponse response){
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(msg.getBytes());
            outputStream.flush();
            outputStream.close();
            log.debug("————————————数据处理完成————————————");
        }catch (IOException exception){
            try {
                if(outputStream != null){
                    outputStream.close();
                }
            }catch (Exception e){
                log.debug("");
            }
        }
    }
    private static volatile HttpProcessService httpProcessService;

    /**
     * Gets the value of httpProcessService. *
     *
     * @return the value of httpProcessService
     */
    public static HttpProcessService getHttpProcessService() {
        if(httpProcessService == null){
            synchronized (HttpProcessService.class){
                if (httpProcessService == null){
                    httpProcessService = new HttpProcessService();
                }
            }
        }
        return httpProcessService;
    }
}
