package com.fc.msp.message;

import com.fc.msp.config.apolloconfig.ApolloConfigurationListener;

import java.util.Map;

/**
 * @ClassName TCPResponseMessage
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/21 12:27 下午
 * @Version 1.0
 */
public class TcpResponseMessage implements MessageFactory{
    private static Map<String, String> map = ApolloConfigurationListener.getResponseData();
    @Override
    public String createMessage(String resMsg) {
        StringBuffer res = new StringBuffer();
        res.append(map.get(resMsg));
        return res.toString();
    }
}
