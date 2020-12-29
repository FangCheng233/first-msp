package com.fc.msp.mspalert.filter;

import com.fc.msp.mspalert.entity.Alert;
import com.fc.msp.mspalert.filter.config.FilterConfig;

import java.util.stream.Stream;

/**
 * @ClassName MessageFilter
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/11/18 3:55 下午
 * @Version 1.0
 */
public interface MessageFilter {
    /**
     * @Description 告警信息过滤
     * @Param alert
     * @return 是否需要过滤
     */
     boolean filter(Alert alert, Stream<FilterConfig> configStream);
}
