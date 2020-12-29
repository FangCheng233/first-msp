package com.fc.msp.msplogger;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName AspectService
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/4 4:27 下午
 * @Version 1.0
 */
@Aspect
@Component
public class AspectService {

    @SuppressWarnings("unused")
    @Pointcut("execution (* com.ctrip.framework.apollo.internals.RemoteConfigRepository.RemoteConfigRepository())")
    private void anyMethod() {

    }
    @Around("anyMethod()")
    private static void test(){

    }
}
