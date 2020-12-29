/*
package com.fc.msp.utils.schedule;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

*/
/**
 * @ClassName ScheduledRefreshMSPConfig
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/12/5 10:21 上午
 * @Version 1.0
 *//*

@Component
public class ScheduledCleanUpLocalCache {
    */
/**
     * @Description 获取定时任务配置
     *//*

    @Value("${order.schedule.interval:1000}")
    private Long orderScheduleInterVal;

    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    */
/**
     * TODO 自行实现需要处理的逻辑 清理本地临时缓存信息，如临时数据文件等
     * @Description
     * @Author fangcheng
     * @return void
     * @throws
     * @Date 2020/12/5 10:28 上午
     *//*

    public void refresh() {

    }
    */
/**
     * TODO 重置定时任务
     * @Description
     * @Author fangcheng
     * @param event :
     * @return void
     * @throws
     * @Date 2020/12/5 10:38 上午
     *//*

//    @ApolloConfigChangeListener("")
    public void event(ConfigChangeEvent event){

    }
    */
/**
     * TODO
     * @Description
     * @Author fangcheng
     * @return void
     * @throws
     * @Date 2020/12/5 10:36 上午
     *//*

//    @PostConstruct
    private void preConfig(){

        PeriodicTrigger periodicTrigger = new PeriodicTrigger(orderScheduleInterVal, TimeUnit.MILLISECONDS);
        periodicTrigger.setFixedRate(true);
        periodicTrigger.setInitialDelay(1000);

        threadPoolTaskScheduler.schedule(this::refresh, periodicTrigger);
    }

}
*/
