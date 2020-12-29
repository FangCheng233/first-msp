package com.fc.msp.mspalert.filter;

import com.fc.msp.mspalert.entity.Alert;
import com.fc.msp.mspalert.filter.config.FilterConfig;

import java.util.stream.Stream;

/**
 * @ClassName Executer
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/11/18 4:00 下午
 * @Version 1.0
 */
public abstract class FilterExecutor implements MessageFilter {
    MessageFilter messageFilter;

    public FilterExecutor(MessageFilter messageFilter) {
        this.messageFilter = messageFilter;
    }

    @Override
    public boolean filter(Alert alert, Stream<FilterConfig> configStream) {
        return true;
    }
}
