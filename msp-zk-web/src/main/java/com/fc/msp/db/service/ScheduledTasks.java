package com.fc.msp.db.service;

/**
 * @ClassName DynamicScheduleTaskSecond
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/20 11:53 下午
 * @Version 1.0
 */

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks implements SchedulingConfigurer {

    @Autowired
    DataCollection dataCollection;

    // 配置文件读取
    @Value("${audit.schedule.cron}")
    private String cron;

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                try {
                    //

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Trigger() {

            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                System.out.println("-----------"+cron);
                if ("".equals(cron) || cron == null){
                    return null;
                }
                CronTrigger trigger = new CronTrigger(cron);// 定时任务触发，可修改定时任务的执行周期
                Date nextExecDate = trigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });
    }

}
