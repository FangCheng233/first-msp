/*
package com.fc.msp.utils.schedule;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
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
public class ScheduledRefreshMSPConfig {
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
     * TODO 从nacos\eureka\zookeeper\redis\db、本地配置文件等获取信息刷入内存用于数据处理
     * @Description
     * @Author fangcheng
     * @return void
     * @throws
     * @Date 2020/12/5 10:29 上午
     *//*

    public void refresh() {

    }
    @PostConstruct
    private void preConfig(){

        PeriodicTrigger periodicTrigger = new PeriodicTrigger(orderScheduleInterVal, TimeUnit.MILLISECONDS);
        periodicTrigger.setFixedRate(true);
        periodicTrigger.setInitialDelay(1000);

        threadPoolTaskScheduler.schedule(this::refresh, periodicTrigger);
    }
}
*/
