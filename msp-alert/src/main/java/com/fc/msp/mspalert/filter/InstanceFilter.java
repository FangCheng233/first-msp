package com.fc.msp.mspalert.filter;

import com.fc.msp.mspalert.entity.Alert;
import com.fc.msp.mspalert.filter.config.FilterConfig;

import java.util.stream.Stream;

/**
 * @ClassName InstanceFilter
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/11/18 4:07 下午
 * @Version 1.0
 */
public class InstanceFilter extends FilterExecutor{
    public InstanceFilter(MessageFilter messageFilter) {
        super(messageFilter);
    }

    @Override
    public boolean filter(Alert alert, Stream<FilterConfig> configStream) {
        configStream = configStream.filter(
                filterConfig -> filterConfig.getInstance().equals(alert.getLabels().getInstance())
                        || filterConfig.getInstance().equals("ALL"));
        if(configStream.count() > 0){
            return super.filter(alert, configStream);
        }
        return false;
    }
}
