package com.fc.msp.utils;

import com.fc.msp.mspalert.entity.Alert;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MassageProcessing
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/29 8:13 上午
 * @Version 1.0
 */
@Component
public class MessageProcessing {
    public String parseAlert2MSG(Alert alert){
        String description = alert.getAnnotations().getDescription();
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map map = new HashMap<String,String>();
        map.put("description", description);
        map.put("time", createTime);
        map.put("system", "msp");
        return map.toString();
    }
}
