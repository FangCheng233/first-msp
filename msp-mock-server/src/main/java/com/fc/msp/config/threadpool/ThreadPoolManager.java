package com.fc.msp.config.threadpool;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ThreadPoolManager
 * @Description TODO  根据本地配置或者Apollo配置 创建对应接口线程池
 * @Author fangcheng
 * @Date 2020/8/20 9:14 下午
 * @Version 1.0
 */
public class ThreadPoolManager {

    private static HashMap<String, ExecutorService> threadPools = new HashMap<>(16);
    /**
     *
     * @Description
     * @Author fangcheng

     * @return void
     * @throws
     * @Date 2020/8/21 3:45 下午
     */
    @PostConstruct
    private void createPools(){
        /**
         * 暂时使用executors创建
         *
         * */
        ExecutorService executorService = Executors.newFixedThreadPool(20);
    }
}
