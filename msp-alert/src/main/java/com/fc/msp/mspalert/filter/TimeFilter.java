package com.fc.msp.mspalert.filter;

import com.fc.msp.mspalert.entity.Alert;
import com.fc.msp.mspalert.filter.config.FilterConfig;

import java.util.stream.Stream;

/**
 * @ClassName TimeFilter
 * @Description  判断是否在设定的时间范围
 * @Author fangcheng
 * @Date 2020/11/18 4:08 下午
 * @Version 1.0
 */
public class TimeFilter extends FilterExecutor {
    public TimeFilter(MessageFilter messageFilter) {
        super(messageFilter);
    }

    /**
     *
     * @Description 判断告警时间在不在设置的告警范围之内 12:00:00-23:59:59
     * @Author fangcheng
     * @param alert :
     * @param configStream :
     * @return boolean
     * @throws
     * @Date 2020/11/20 9:27 上午
     */
    @Override
    public boolean filter(Alert alert, Stream<FilterConfig> configStream) {

        configStream = configStream.filter(
                filterConfig -> timeTransFor(alert,filterConfig.getTime())
                        || filterConfig.getAlertName().equals("ALL"));

        if(configStream.count() > 0){
            return super.filter(alert, configStream);
        }
        return false;
    }
    /**
     * TODO
     * @Description 自定义时间处理方式 或使用工具类进行时间处理
     * @Author fangcheng
     * @param time :
     * @return void
     * @throws
     * @Date 2020/11/20 9:32 上午
     */
    private boolean timeTransFor(Alert alert, String time){

        return false;
    }
}
