package com.fc.msp.mspauth;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassName BaseConfig
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/31 11:28 上午
 * @Version 1.0
 */
@Component
@EnableApolloConfig("application")
public class BaseConfig implements Serializable {
    @Value("${value1}")
    public String value1;
    @Value("${value2}")
    public String value2;
    @Value("${value3}")
    public String value3;
    /**
     * Gets the value of value1. *
     *
     * @return the value of value1
     */
    public String getValue1() {
        return value1;
    }

    /**
     * Sets the value1. *
     * <p>You can use getValue1() to get the value of value1</p>
     * * @param value1 value1
     */
    public void setValue1(String value1) {
        this.value1 = value1;
    }

    /**
     * Gets the value of value2. *
     *
     * @return the value of value2
     */
    public String getValue2() {
        return value2;
    }

    /**
     * Sets the value2. *
     * <p>You can use getValue2() to get the value of value2</p>
     * * @param value2 value2
     */
    public void setValue2(String value2) {
        this.value2 = value2;
    }

    /**
     * Gets the value of value3. *
     *
     * @return the value of value3
     */
    public String getValue3() {
        return value3;
    }

    /**
     * Sets the value3. *
     * <p>You can use getValue3() to get the value of value3</p>
     * * @param value3 value3
     */
    public void setValue3(String value3) {
        this.value3 = value3;
    }
}
