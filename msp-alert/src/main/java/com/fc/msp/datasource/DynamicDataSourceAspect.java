package com.fc.msp.datasource;

import com.fc.msp.datasource.DataSource;
import com.fc.msp.datasource.config.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @ClassName DynamicDataSourceAspect
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/12/3 12:51 下午
 * @Version 1.0
 */
@Slf4j
@Aspect
@Component
public class DynamicDataSourceAspect {
    // pointCut
    @Pointcut("@annotation(com.fc.msp.datasource.DataSource)")
    public void choseDatasourceByAnnotation() {
    }
    @Pointcut("@within(com.fc.msp.datasource.DataSource)")
    public void choseDatasourceByClass() {
    }
    @Pointcut("execution(* com.fc.msp.mspalert.mapper.user..*(..))")
    public void choseDatasourceByPackage() {
    }

    @Around("choseDatasourceByAnnotation() || choseDatasourceByClass() || choseDatasourceByPackage()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("进入AOP环绕通知");
        Signature signature = joinPoint.getSignature();
        String datasourceName = getDatasourceKey(signature);
        if (!Objects.isNull(datasourceName)) {
            DynamicDataSource.setDataSourceName(datasourceName);
        }
        return joinPoint.proceed();
    }
    private String getDatasourceKey(Signature signature) {
        if (signature == null) {
            return null;
        } else {
            if (signature instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) signature;
                Method method = methodSignature.getMethod();
                if (method.isAnnotationPresent(DataSource.class)) {
                    return this.dsSettingInMethod(method);
                }
                Class<?> declaringClass = method.getDeclaringClass();
                if (declaringClass.isAnnotationPresent(DataSource.class)) {
                    return this.dsSettingInConstructor(declaringClass);
                }
                Package aPackage = declaringClass.getPackage();
                this.dsSettingInPackage(aPackage);
            }
            return null;
        }
    }
    private String dsSettingInConstructor(Class<?> declaringClass) {
        DataSource dataSource = declaringClass.getAnnotation(DataSource.class);
        return dataSource.value();
    }
    private String dsSettingInMethod(Method method) {
        DataSource dataSource = method.getAnnotation(DataSource.class);
        return dataSource.value();
    }
    private void dsSettingInPackage(Package pkg) {
        DynamicDataSource.usePackageDatasourceKey(pkg.getName());
    }
}
