package com.fc.msp.datasource;

import java.lang.annotation.*;

/**
 * @ClassName DataSource
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/12/3 12:30 下午
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.PACKAGE})
@Documented
public @interface DataSource {
    String value() default DataSourceConfig.DEFAULT_DATASOURCE;
}
