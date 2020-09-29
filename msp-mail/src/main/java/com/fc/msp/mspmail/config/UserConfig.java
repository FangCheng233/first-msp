package com.fc.msp.mspmail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserConfig
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/29 1:19 下午
 * @Version 1.0
 */
//@Component
public class UserConfig {


    private String user;

    private String password;

    private Map<String, String> userList;
    /**
     * Gets the value of user. *
     *
     * @return the value of user
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the user. *
     * <p>You can use getUser() to get the value of user</p>
     * * @param user user
     */
    @Value("${usermail:286500543@qq.com}")
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets the value of password. *
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password. *
     * <p>You can use getPassword() to get the value of password</p>
     * * @param password password
     */
    @Value("${password}")
    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, String> getUserList() {
        return userList;
    }

    public void setUserList(Map<String, String> userList) {
        this.userList = userList;
    }
}
