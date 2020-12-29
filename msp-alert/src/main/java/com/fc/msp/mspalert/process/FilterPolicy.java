package com.fc.msp.mspalert.process;

import com.fc.msp.mspalert.filter.config.FilterConfig;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName FilterPolicy
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/11/7 5:04 下午
 * @Version 1.0
 */
public class FilterPolicy {
    /**
     * @Description 过滤告警信息的具体策略
     */
    private static ArrayList<FilterConfig> filters = new ArrayList<>();
//    private
    public static void main(String[] args) {
        String name = "";
        filters.stream().filter(filterConfig -> filterConfig.getAlertName().equals(name));
    }
}
