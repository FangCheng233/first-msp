package com.fc.msp.zkclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ZookeeperConfig
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/11 9:32 下午
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "configs")
public class ZookeeperConfig {

    public List<Config> configList = new ArrayList<>();

    /**
     * Gets the value of configList. *
     *
     * @return the value of configList
     */
    public List<Config> getConfigList() {
        return configList;
    }

    /**
     * Sets the configList. *
     * <p>You can use getConfigList() to get the value of configList</p>
     * * @param configList configList
     */
    public void setConfigList(List<Config> configList) {
        this.configList = configList;
    }

    public static class Config{
        private String env;
        private String zkUrl;
        private int timeout;
        private String acl;

        /**
         * Gets the value of env. *
         *
         * @return the value of env
         */
        public String getEnv() {
            return env;
        }

        /**
         * Sets the env. *
         * <p>You can use getEnv() to get the value of env</p>
         * * @param env env
         */
        public void setEnv(String env) {
            this.env = env;
        }

        /**
         * Gets the value of zkUrl. *
         *
         * @return the value of zkUrl
         */
        public String getZkUrl() {
            return zkUrl;
        }

        /**
         * Sets the zkUrl. *
         * <p>You can use getZkUrl() to get the value of zkUrl</p>
         * * @param zkUrl zkUrl
         */
        public void setZkUrl(String zkUrl) {
            this.zkUrl = zkUrl;
        }

        /**
         * Gets the value of timeout. *
         *
         * @return the value of timeout
         */
        public int getTimeout() {
            return timeout;
        }

        /**
         * Sets the timeout. *
         * <p>You can use getTimeout() to get the value of timeout</p>
         * * @param timeout timeout
         */
        public void setTimeout(int timeout) {
            this.timeout = timeout;
        }

        /**
         * Gets the value of acl. *
         *
         * @return the value of acl
         */
        public String getAcl() {
            return acl;
        }

        /**
         * Sets the acl. *
         * <p>You can use getAcl() to get the value of acl</p>
         * * @param acl acl
         */
        public void setAcl(String acl) {
            this.acl = acl;
        }

        @Override
        public String toString() {
            return "Config{" +
                    "env='" + env + '\'' +
                    ", zkUrl='" + zkUrl + '\'' +
                    ", timeout=" + timeout +
                    ", acl='" + acl + '\'' +
                    '}';
        }
    }
    @PostConstruct
    public void say(){

    }
}
