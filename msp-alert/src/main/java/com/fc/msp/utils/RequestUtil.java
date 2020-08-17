package com.fc.msp.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fc.msp.mspalert.entity.Alerts;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @ClassName RequestUtil
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/26 5:27 下午
 * @Version 1.0
 */
public class RequestUtil {
    /**
     *
     * @Description
     * @Author fangcheng
     * @param request :
     * @return java.lang.String
     * @throws
     * @Date 2020/7/27 10:54 上午
     */
    public static String readAsBytes(HttpServletRequest request) {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null){
                jb.append(line);
            }
        } catch (Exception e) {
            /*report an error*/
        }
        return new String(jb);
    }
    /**
     *
     * @Description
     * @Author fangcheng
     * @param alertsMsg :
     * @return com.fc.msp.mspalert.entity.Alerts
     * @throws
     * @Date 2020/7/27 10:59 上午
     */
    public static Alerts alert2JSON(String alertsMsg){
        Alerts alerts = JSON.parseObject(alertsMsg, Alerts.class);
        return alerts;
    }
}
