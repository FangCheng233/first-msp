package com.fc.msp.mspalert.filter;

import com.fc.msp.mspalert.entity.Alert;
import com.fc.msp.mspalert.filter.config.FilterConfig;

import java.util.stream.Stream;

/**
 * @ClassName ServiceFilter
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/11/18 4:12 下午
 * @Version 1.0
 */
public class ServiceFilter extends FilterExecutor {
    public ServiceFilter(MessageFilter messageFilter) {
        super(messageFilter);
    }

    @Override
    public boolean filter(Alert alert, Stream<FilterConfig> configStream) {
        configStream = configStream.filter(
                filterConfig -> filterConfig.getService().equals(alert.getLabels())
                        || filterConfig.getAlertName().equals("ALL"));
        if(configStream.count() > 0){
            return super.filter(alert, configStream);
        }
        return false;
    }
}
