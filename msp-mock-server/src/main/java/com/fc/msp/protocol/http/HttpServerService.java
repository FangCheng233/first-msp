package com.fc.msp.protocol.http;

import com.fc.msp.config.apolloconfig.MockConfig;
import com.fc.msp.protocol.ServerManager;
import com.fc.msp.service.interfaces.IService;
import com.sun.net.httpserver.HttpServer;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;

import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName HttpServerService
 * @Description TODO 每个server 维护一份过滤清单
 * @Author fangcheng
 * @Date 2020/8/23 2:34 下午
 * @Version 1.0
 */
@Slf4j
public class HttpServerService implements IService {
    private static Server SERVER = null;
    private int PORT = 0;
    private MockConfig mockConfig = null;

    private Set<MockConfig> URL = new TreeSet<>();

    /**
     * Gets the value of URL. *
     *
     * @return the value of URL
     */
    public Set<MockConfig> getURL() {
        return URL;
    }

    public HttpServerService(MockConfig mockConfig) {
        this.mockConfig = mockConfig;
        this.PORT = mockConfig.getPort();
    }

    public void startJetty(){
        try {
            URL.add(mockConfig);
            // 进行服务器配置
            SERVER = new Server();
            //在/hello路径上增加一个处理器
            ContextHandler context = new ContextHandler();
            context.setContextPath(mockConfig.getUrl());
            ServerConnector selectConnector = new ServerConnector(SERVER);
            selectConnector.setAcceptedReceiveBufferSize(8192);
            selectConnector.setAcceptedSendBufferSize(8192);
            selectConnector.setAcceptQueueSize(2000);
            selectConnector.setPort(PORT);
            SERVER.setConnectors(new Connector[]{selectConnector});
            SERVER.addConnector(selectConnector);
            SessionHandler sessionHandler = new SessionHandler();
            ServletHandler servletHandler = new ServletHandler();
            sessionHandler.getHttpOnly();
            sessionHandler.setHandler(servletHandler);
            HttpReceiveHandler receiveHandler = new HttpReceiveHandler(mockConfig);
//            ServletContextHandler contextHandler = new ServletContextHandler();
            SERVER.setHandler(receiveHandler);

            ServerManager.getServerMap().put(PORT,this);
            SERVER.setStopAtShutdown(true);
            // 启动服务器
            SERVER.start();
            log.info("Http 服务已启动端口号为{}", PORT);
        } catch (Exception e) {

        }finally {
//            try {
//                SERVER.stop();
//                log.info("出现异常已关闭jetty服务端口号为{}", PORT);
//            }catch (Exception exception){
//
//            }
        }
    }
    public void stopJetty(){
        try {
            // 当前端口拦截 URL 为空 停止当前端口
            SERVER.stop();
            log.info("Jetty 服务已关闭端口号为{}", PORT);
        }catch (Exception e){

        }finally {

        }
    }
    /**
     *
     * @Description 同一端口新增配置时使用
     * @Author fangcheng
     * @param mockConfig :
     * @return void
     * @throws
     * @Date 2020/8/23 4:43 下午
     */
    public void addConfig(MockConfig mockConfig){
        URL.add(mockConfig);
    }
    /**
     *
     * @Description 同一端口
     * @Author fangcheng
     * @param mockConfig :
     * @return void
     * @throws
     * @Date 2020/8/23 4:43 下午
     */
    public void remConfig(MockConfig mockConfig){
        URL.remove(mockConfig);
        if(URL.size() == 0){
            stopJetty();
        }
    }
}
