package com.fc.msp.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName ApplicationContextHelper
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/22 8:12 下午
 * @Version 1.0
 */
@Component
public class ApplicationContextHelper implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public ApplicationContextHelper() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHelper.applicationContext = applicationContext;
    }

    public static Object getBean(String beanName) {
        return applicationContext != null?applicationContext.getBean(beanName):null;
    }
}
