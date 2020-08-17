package com.fc.msp.mspalert.service;

import com.alibaba.fastjson.JSONException;
import com.fc.msp.config.AlertPushConfig;
import com.fc.msp.config.ApolloConfiguration;
import com.fc.msp.config.ConfigurationProperties;
import com.fc.msp.mspalert.entity.Alert;
import com.fc.msp.mspalert.entity.AlertInfo;
import com.fc.msp.mspalert.entity.AlertMsgInfo;
import com.fc.msp.mspalert.entity.Alerts;
import com.fc.msp.mspalert.mapper.AlertInfoMapper;
import com.fc.msp.mspalert.mapper.AlertMsgInfoMapper;
import com.fc.msp.mspalert.process.AlertFilter;
import com.fc.msp.notify.email.SendMessage;
import com.fc.msp.utils.MessageProcessing;
import com.fc.msp.utils.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName WebHookService
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/29 9:29 上午
 * @Version 1.0
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class WebHookService {

    private static Logger log = LoggerFactory.getLogger(WebHookService.class);
    @Autowired
    AlertFilter alertFilter;
    @Autowired
    SendMessage sendMessage;
    @Resource
    AlertPushConfig alertPushConfig;
    @Autowired
    MessageProcessing messageProcessing;
    @Autowired
    AlertInfoMapper alertInfoMapper;
    @Autowired
    AlertMsgInfoMapper alertMsgInfoMapper;

    @Resource
    ApolloConfiguration apolloConfiguration;

    private static String STATUS = "0";
    @Async
    public void dealWithMsg(String alertMsg){
        Alerts alerts = parseAlertMsg2Alerts(alertMsg);
        boolean isAvailable = verifyAlerts(alerts);
        if(!isAvailable){
            log.info("告警信息为空，该条告警不做后续处理");
            return;
        }
        AlertMsgInfo alertMsgInfo = new AlertMsgInfo();
        alertMsgInfo.setAlertMsg(alertMsg);
        alertMsgInfoMapper.insert(alertMsgInfo);
        Integer alertMsgId = alertMsgInfo.getId();
        List<Alert> alertList = alerts.getAlerts();
        for(Alert alert : alertList){
            saveAlert(alert, alertMsgId);
            if(alertFilter.pushFilter(alert)){
                pushMsg(alert);
            }
        }
    }
    /**
     *
     * @Description 根据配置信息推送对应服务
     * @Author fangcheng
     * @param alert :
     * @return void
     * @throws
     * @Date 2020/7/29 10:16 上午
     */
    public void pushMsg(Alert alert){
        String sendMSG = messageProcessing.parseAlert2MSG(alert);
        if(alertPushConfig.getEnableEmail().equals("true")){
            sendMessage.sendDirectMessage(sendMSG);
        }
        if(alertPushConfig.getEnableSMS().equals("true")){

        }
        if(alertPushConfig.getEnableWeChat().equals("true")){

        }
    }
    /**
     *
     * @Description 保存单条告警信息，通过Alert_Msg_Id与原始告警信息关联
     * @Author fangcheng
     * @param alert :
     * @param alertMsgId :
     * @return void
     * @throws
     * @Date 2020/8/1 9:00 上午
     */
    public void saveAlert(Alert alert, Integer alertMsgId){
        AlertInfo alertInfo = new AlertInfo();
        alertInfo.setDescription(alert.getAnnotations().getDescription());
        alertInfo.setAlertName(alert.getLabels().getAlertname());
        alertInfo.setAlertMsgId(alertMsgId);
        alertInfo.setStatus(alert.getStatus());
        String createTime = ConfigurationProperties.formatter.format(new Date());
        alertInfo.setCreateTime(createTime);
        alertInfoMapper.insert(alertInfo);
    }

    /**
     *
     * @Description 验证告警信息是否完整，是否需要后续处理
     * @Author fangcheng
     * @param alerts :
     * @return boolean
     * @throws
     * @Date 2020/7/29 9:42 上午
     */
    public boolean verifyAlerts(Alerts alerts){
        if(alerts == null){
            return false;
        }
        if (alerts.getAlerts() == null){
            return false;
        }
        return true;
    }
    /**
     *
     * @Description 将alertmanager推送的告警信息转换为Java对象，方便后续处理
     * @Author fangcheng
     * @param alertMsg :
     * @return com.fc.msp.mspalert.entity.Alerts
     * @throws
     * @Date 2020/7/29 9:35 上午
     */
    public Alerts parseAlertMsg2Alerts(String alertMsg){
        Alerts alerts = null;
        try {
            alerts = RequestUtil.alert2JSON(alertMsg);
        }catch (JSONException e){
            log.warn("parse alertMsg failed");
        }
        return alerts;
    }
}
