package com.fc.msp.mspmail;

import com.fc.msp.mspmail.send.MailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName MessageTest
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/29 1:02 下午
 * @Version 1.0
 */
public class MessageTest {
    @Autowired
    MailService mailService;
    @Test
    public void test(){
        mailService.send("TEST","www.2441014356@qq.com","Hello World!");
    }
}
