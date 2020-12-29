package com.fc.msp.mspalert.controller;

import com.fc.msp.mspalert.service.WebHookService;
import com.fc.msp.utils.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api
@RestController
public class WebHookController {
    private static Logger log = LoggerFactory.getLogger(WebHookController.class);
    @Autowired()
    private WebHookService webHookService;

    @ApiParam(name = "request")
    @ApiOperation(value = "数据接口", notes = "数据接口")
    @PostMapping("webHook")
    public String webHookkkk(HttpServletRequest request){
        /**
        * 可添加对来源的校验
        */
        String alertRequest = RequestUtil.readAsBytes(request);
        log.info(alertRequest);

        webHookService.dealWithMsg(alertRequest);

        return "success!";
    }
}
