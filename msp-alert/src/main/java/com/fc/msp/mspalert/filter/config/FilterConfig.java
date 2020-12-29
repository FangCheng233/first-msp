package com.fc.msp.mspalert.filter.config;

import java.io.Serializable;

/**
 * @ClassName FilterConfig
 * @Description 告警过滤基本信息
 * @Author fangcheng
 * @Date 2020/11/3 4:54 下午
 * @Version 1.0
 */
public class FilterConfig implements Serializable {
    /**
     * @Description 获取过滤的数据配置
     * @return 获取需要过滤的数据信息 微服务->实例->时间->类型->->
     */
    /**
     * @Description 告警指标名称
     */
    private String alertName;
    /**
     * @Description 告警实例 IP+port
     */
    private String instance;
    /**
     * @Description 告警时间范围 start-end
     */
    private String time;
    /**
     * @Description 告警次数
     */
    private String times;
    /**
     * @Description 告警频率
     */
    private String rate;
    /**
     * @Description 告警信息所属系统
     */
    private String system;
    /**
     * @Description 微服务名称
     */
    private String service;

    /**
     * Gets the value of alertName. *
     *
     * @return the value of alertName
     */
    public String getAlertName() {
        return alertName;
    }

    /**
     * Sets the alertName. *
     * <p>You can use getAlertName() to get the value of alertName</p>
     * * @param alertName alertName
     */
    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }

    /**
     * Gets the value of instance. *
     *
     * @return the value of instance
     */
    public String getInstance() {
        return instance;
    }

    /**
     * Sets the instance. *
     * <p>You can use getInstance() to get the value of instance</p>
     * * @param instance instance
     */
    public void setInstance(String instance) {
        this.instance = instance;
    }

    /**
     * Gets the value of time. *
     *
     * @return the value of time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time. *
     * <p>You can use getTime() to get the value of time</p>
     * * @param time time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets the value of times. *
     *
     * @return the value of times
     */
    public String getTimes() {
        return times;
    }

    /**
     * Sets the times. *
     * <p>You can use getTimes() to get the value of times</p>
     * * @param times times
     */
    public void setTimes(String times) {
        this.times = times;
    }

    /**
     * Gets the value of rate. *
     *
     * @return the value of rate
     */
    public String getRate() {
        return rate;
    }

    /**
     * Sets the rate. *
     * <p>You can use getRate() to get the value of rate</p>
     * * @param rate rate
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * Gets the value of system. *
     *
     * @return the value of system
     */
    public String getSystem() {
        return system;
    }

    /**
     * Sets the system. *
     * <p>You can use getSystem() to get the value of system</p>
     * * @param system system
     */
    public void setSystem(String system) {
        this.system = system;
    }

    /**
     * Gets the value of service. *
     *
     * @return the value of service
     */
    public String getService() {
        return service;
    }

    /**
     * Sets the service. *
     * <p>You can use getService() to get the value of service</p>
     * * @param service service
     */
    public void setService(String service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterConfig that = (FilterConfig) o;

        if (alertName != null ? !alertName.equals(that.alertName) : that.alertName != null) return false;
        if (instance != null ? !instance.equals(that.instance) : that.instance != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (times != null ? !times.equals(that.times) : that.times != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        if (system != null ? !system.equals(that.system) : that.system != null) return false;
        return service != null ? service.equals(that.service) : that.service == null;
    }

    @Override
    public int hashCode() {
        int result = alertName != null ? alertName.hashCode() : 0;
        result = 31 * result + (instance != null ? instance.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (times != null ? times.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (system != null ? system.hashCode() : 0);
        result = 31 * result + (service != null ? service.hashCode() : 0);
        return result;
    }
}
