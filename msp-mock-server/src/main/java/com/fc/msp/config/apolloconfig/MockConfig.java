package com.fc.msp.config.apolloconfig;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName MockConfig
 * @Description TODO 挡板接口的具体配置
 * @Author fangcheng
 * @Date 2020/8/21 4:47 下午
 * @Version 1.0
 */
@Resource
public class MockConfig extends BaseConfig{
    /**
     * @Description GET/POST/PUT/DELETE
     */
    private String method;
    /**
     * @Description http请求时设置,接口URL
     */
    private String url;
    /**
     * @Description http请求时设置
     */
    private String contentType;
    /**
     * @Description http请求时设置
     */
    private int responseStatus;
    /**
     * @Description http请求时设置
     */
    private String[] responseHeader;
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
    /**
     * Gets the value of method. *
     *
     * @return the value of method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the method. *
     * <p>You can use getMethod() to get the value of method</p>
     * * @param method method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Gets the value of url. *
     *
     * @return the value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url. *
     * <p>You can use getUrl() to get the value of url</p>
     * * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the value of contentType. *
     *
     * @return the value of contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the contentType. *
     * <p>You can use getContentType() to get the value of contentType</p>
     * * @param contentType contentType
     */
    @Value(value = "${contentType}:application/json;charset=UTF-8")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Gets the value of responseStatus. *
     *
     * @return the value of responseStatus
     */
    public int getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets the responseStatus. *
     * <p>You can use getResponseStatus() to get the value of responseStatus</p>
     * * @param responseStatus responseStatus
     */
    @Value(value = "200")
    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

    /**
     * Gets the value of responseHeader. *
     *
     * @return the value of responseHeader
     */
    public String[] getResponseHeader() {
        return responseHeader;
    }

    /**
     * Sets the responseHeader. *
     * <p>You can use getResponseHeader() to get the value of responseHeader</p>
     * * @param responseHeader responseHeader
     */
    public void setResponseHeader(String[] responseHeader) {
        this.responseHeader = responseHeader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MockConfig that = (MockConfig) o;
        return responseStatus == that.responseStatus &&
                port == that.port &&
                method.equals(that.method) &&
                url.equals(that.url) &&
                contentType.equals(that.contentType) &&
                Arrays.equals(responseHeader, that.responseHeader);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(method, url, contentType, responseStatus, port);
        result = 31 * result + Arrays.hashCode(responseHeader);
        return result;
    }
}
