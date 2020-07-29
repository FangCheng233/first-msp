package com.fc.msp.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName ApolloConfiguration
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/29 8:20 上午
 * @Version 1.0
 */
@Component
@Configuration
public class ApolloConfiguration {

    @ApolloConfig
    Config config;

    @Bean
    public ApolloConfiguration ApolloConfiguration() {
        return new ApolloConfiguration();
    }

    /**
     * Gets the value of config. *
     *
     * @return the value of config
     */
    public Config getConfig() {
        return config;
    }

    /**
     * Sets the config. *
     * <p>You can use getConfig() to get the value of config</p>
     * * @param config config
     */
    public void setConfig(Config config) {
        this.config = config;
    }
}
