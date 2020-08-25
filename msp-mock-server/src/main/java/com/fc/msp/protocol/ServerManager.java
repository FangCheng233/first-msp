package com.fc.msp.protocol;

import com.fc.msp.service.interfaces.IService;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ServerManager
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/23 3:11 下午
 * @Version 1.0
 */
@Configuration
public class ServerManager {
    /**
     * @Description  存放所有的server信息
     */
    private static volatile Map<Integer, IService> serverMap = new ConcurrentHashMap<>(16);

    /**
     * Gets the value of serverMap. *
     *
     * @return the value of serverMap
     */
    public static Map<Integer, IService> getServerMap() {
        return serverMap;
    }
    /**
     *
     * @Description 检查端口是否重复开启
     * @Author fangcheng
     * @param port :
     * @return boolean
     * @throws
     * @Date 2020/8/23 3:41 下午
     */
    public static synchronized boolean checkPort(int port){
        return serverMap.containsKey(port);
    }
}
