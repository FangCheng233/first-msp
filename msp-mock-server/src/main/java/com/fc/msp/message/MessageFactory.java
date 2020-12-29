package com.fc.msp.message;

import org.springframework.stereotype.Service;

/**
 * @ClassName MessageFactory
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/20 9:06 下午
 * @Version 1.0
 */
@Service
public interface MessageFactory {
    public String createMessage(String resMsg);
    public String createExceptionMessage(String resMsg);
}
