package com.fc.msp.config.apolloconfig;

/**
 * @ClassName HttpConfig
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/21 8:39 下午
 * @Version 1.0
 */
public class HttpConfig extends BaseConfig{
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
    private String responseStatus;
    /**
     * @Description http请求时设置
     */
    private String[] responseHeader;

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
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Gets the value of responseStatus. *
     *
     * @return the value of responseStatus
     */
    public String getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets the responseStatus. *
     * <p>You can use getResponseStatus() to get the value of responseStatus</p>
     * * @param responseStatus responseStatus
     */
    public void setResponseStatus(String responseStatus) {
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
}
