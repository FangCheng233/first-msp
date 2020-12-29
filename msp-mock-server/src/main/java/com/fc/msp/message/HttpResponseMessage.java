package com.fc.msp.message;

import com.fc.msp.config.apolloconfig.ApolloConfigurationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName HttpResponseMessage
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/21 12:29 下午
 * @Version 1.0
 */
public class HttpResponseMessage implements MessageFactory{
    private static Map<String, String> map = ApolloConfigurationListener.getResponseData();

    /**
     *
     * @Description
     * @Author fangcheng
     * @param resMsg :
     * @return java.lang.String
     * @throws
     * @Date 2020/8/22 7:07 下午
     */
    @Override
    public String createMessage(String resMsg) {

        return map.get(resMsg);
    }

    /**
     *
     * @Description
     * @Author fangcheng
     * @param resMsg :
     * @return java.lang.String
     * @throws
     * @Date 2020/8/22 7:07 下午
     */
    @Override
    public String createExceptionMessage(String resMsg) {
        String msg = "找不到对应配置";
        return msg;
    }
}
