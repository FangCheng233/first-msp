package com.fc.msp.service.impl;

import com.fc.msp.config.apolloconfig.MockConfig;
import com.fc.msp.message.HttpResponseMessage;
import com.fc.msp.protocol.ServerManager;
import com.fc.msp.protocol.http.HttpServerService;
import com.fc.msp.service.interfaces.IService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Request;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

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
    public void handlerRequest(Request request, MockConfig mockConfig, HttpServletResponse servletResponse){
        log.info("————————————接收到新的请求————————————");
        int port = request.getMetaData().getURI().getPort();//获取请求端口
//        String url = request.getMetaData().getURI().getPath();//获取请求路径
//        String method = request.getMethod();//获取请求类型
        String retMSG = "";
        //根据端口获取对应的server
        Set<MockConfig> mockConfigs = ((HttpServerService)ServerManager.getServerMap().get(port)).getURL();
        // 接收数据
        log.info("接收到的数据为：" + readData(request));
        retMSG = new HttpResponseMessage().createMessage(mockConfig.getResponseMsg());
        servletResponse.setContentType("text/html; charset=utf-8");
        servletResponse.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = null;
        try {
            out = servletResponse.getWriter();
            out.println(retMSG);
            request.setHandled(true);
        }catch (IOException e){
            log.error("——————————出大事了————————————");
        }finally {
            try {
                if(out != null){
                    out.close();
                }
            }catch (Exception exception){

            }
        }
    }
    public String readData(Request request){
        StringBuffer stringBuffer =  new StringBuffer("");
        try {
            BufferedReader br = request.getReader();
            String str = "";
            while((str = br.readLine()) != null){
                stringBuffer.append(str);
            }
        }catch (IOException e){

        }
        return stringBuffer.toString();
    }
}
