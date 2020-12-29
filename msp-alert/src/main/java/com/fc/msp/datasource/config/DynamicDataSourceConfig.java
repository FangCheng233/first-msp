package com.fc.msp.datasource.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.fc.msp.datasource.DataSourceConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DynamicDataSourceConfig
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/12/3 12:56 下午
 * @Version 1.0
 */
@Configuration
public class DynamicDataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource firstDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    public DataSource secondDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(DataSourceConfig.DEFAULT_DATASOURCE, firstDataSource);
        targetDataSources.put(DataSourceConfig.SLAVE_DATASOURCE, secondDataSource);

        //配置包级别的数据源
        Map<String, String> packageDataSource = new HashMap<>();
        packageDataSource.put("com.fc.msp.mspalert.mapper.user", DataSourceConfig.SLAVE_DATASOURCE);

        DynamicDataSource dynamicDataSource = new DynamicDataSource(firstDataSource, targetDataSources);
        dynamicDataSource.setPackageDatasource(packageDataSource);
        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;
    }
}
