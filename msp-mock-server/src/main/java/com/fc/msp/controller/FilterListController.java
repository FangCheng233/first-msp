package com.fc.msp.controller;

import com.fc.msp.config.apolloconfig.MockConfig;
import com.fc.msp.protocol.ServerManager;
import com.fc.msp.protocol.http.HttpServerService;
import com.fc.msp.service.interfaces.IService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName FilterListController
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/24 10:34 上午
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/filter")
public class FilterListController {

    private static String url;
    @GetMapping(value = "/list")
    public List<String> getFilterURL(){
        List<String> filterList = new ArrayList<>(16);
        Iterator<IService> iServiceIterator = ServerManager.getServerMap().values().iterator();
        while (iServiceIterator.hasNext()){
            Iterator<MockConfig> mockConfigIterator = ((HttpServerService)iServiceIterator.next()).getURL().iterator();
            while (mockConfigIterator.hasNext()){
                filterList.add(mockConfigIterator.next().getUrl());
            }

        }
        return filterList;
    }
}
