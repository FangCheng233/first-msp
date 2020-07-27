package com.fc.msp.mspalert.controller;

import com.fc.msp.utils.RequestUtil;
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

    @PostMapping("webHook")
    public String webHook(HttpServletRequest request){
        request.getSession().getAttribute("");
        String alertRequest = RequestUtil.readAsBytes(request);
        System.out.println(alertRequest);
        System.out.println(RequestUtil.alert2JSON(alertRequest));
        return "success!";
    }
}
