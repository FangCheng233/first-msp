package com.fc.msp.config.apolloconfig;

import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName TcpConfig
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/21 8:38 下午
 * @Version 1.0
 */
public class TcpConfig extends BaseConfig{
    /**
     * @Description socket请求端口号
     */
    @Value(value = "1111")
    private int port;

    /**
     * Gets the value of port. *
     *
     * @return the value of port
     */
    public int getPort() {
        return port;
    }

    /**
     * Sets the port. *
     * <p>You can use getPort() to get the value of port</p>
     * * @param port port
     */
    public void setPort(int port) {
        this.port = port;
    }
}
