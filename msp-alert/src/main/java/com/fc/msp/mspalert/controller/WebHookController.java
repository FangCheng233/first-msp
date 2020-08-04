package com.fc.msp.mspalert.controller;

import com.fc.msp.mspalert.service.WebHookService;
import com.fc.msp.utils.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName WebHookController
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/26 5:10 下午
 * @Version 1.0
 */

@RestController("/")
public class WebHookController {
    Logger log = LoggerFactory.getLogger(WebHookController.class);
    @Autowired
    private WebHookService webHookService;

    @PostMapping("webHook")
    public String webHook(HttpServletRequest request){
        /**
        * 可添加对来源的校验
        */
        String alertRequest = RequestUtil.readAsBytes(request);
        log.info(alertRequest);
        for(int i = 0; i<10000; i++){
            webHookService.dealWithMsg(alertRequest);
        }
        return "success!";
    }
}
