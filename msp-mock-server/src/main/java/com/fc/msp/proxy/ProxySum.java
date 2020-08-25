package com.fc.msp.proxy;


import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProxySum
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/25 10:46 上午
 * @Version 1.0
 */
@Aspect
@Component
public class ProxySum {
    @Pointcut(value = "execution(* com.fc.msp..*.*(..))")
    public void point(){

    }
    @Around(value = "point()")
    public void t1(){
        System.out.println(1);
    }
}
