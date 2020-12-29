package com.fc.msp.datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName DynamicDataSource
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/12/3 12:46 下午
 * @Version 1.0
 */

public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * ThreadLocal 用于提供线程局部变量，在多线程环境可以保证各个线程里的变量独立于其它线程里的变量。
     * 也就是说 ThreadLocal 可以为每个线程创建一个【单独的变量副本】，相当于线程的 private static 类型变量。
     */
    private static final ThreadLocal<String> dataSourceName = new ThreadLocal<String>();
    /**
     * 支持以包名的粒度选择数据源
     */
    private static final Map<String,String> packageDataSource = new HashMap<>();

    public DynamicDataSource(DataSource firstDataSource, Map<Object, Object> targetDataSources) {
        setDefaultTargetDataSource(firstDataSource);
        setTargetDataSources(targetDataSources);
        afterPropertiesSet();
    }

    /**
     * 获取与线程上下文绑定的数据源名称（存储在ThreadLocal中）
     * @return 返回数据源名称
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String dsName = dataSourceName.get();
        dataSourceName.remove();
        return dsName;
    }
    public static void setDataSourceName(String dataSource){
        dataSourceName.set(dataSource);
    }
    public static void usePackageDatasourceKey(String pkName) {
        dataSourceName.set(packageDataSource.get(pkName));
    }
    public Map<String,String> getPackageDatasource(){
        return packageDataSource;
    }
    public void setPackageDatasource(Map<String,String> packageDatasource){
        packageDataSource.putAll(packageDatasource);
    }
}
