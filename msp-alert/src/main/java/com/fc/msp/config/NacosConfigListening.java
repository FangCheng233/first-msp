package com.fc.msp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
/**
 * @ClassName NacosConfig
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/12/19 9:51 上午
 * @Version 1.0
 */
@Slf4j
@Service
public class NacosConfigListening {
    @NacosConfigListener(dataId = "notify.properties", groupId = "MSP_GROUP")
    public void refresh1(String content){
        log.info("数据刷新,新的数据为 {}",content);
    }
    @NacosConfigListener(dataId = "mysql.properties", groupId = "MSP_GROUP")
    public void refresh2(String content){
        log.info("数据刷新,新的数据为 {}",content);
    }
    @NacosConfigListener(dataId = "rabbitMq.properties", groupId = "MSP_GROUP")
    public void refresh3(String content){
        log.info("数据刷新,新的数据为 {}",content);
    }
}
