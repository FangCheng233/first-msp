package com.fc.msp.config.threadpool;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolManager
 * @Description TODO  根据本地配置或者Apollo配置 创建对应接口线程池
 * @Author fangcheng
 * @Date 2020/8/20 9:14 下午
 * @Version 1.0
 */
@Slf4j
public class ThreadPoolManager {

    private volatile static HashMap<String, ExecutorService> threadPools = new HashMap<>(16);
    /**
     *
     * @Description
     * @Author fangcheng

     * @return void
     * @throws
     * @Date 2020/8/21 3:45 下午
     */
    public static void createPools(){
        /**
         * 暂时使用executors创建
         *
         * */
        ExecutorService http = new ThreadPoolExecutor(75, 100,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        log.info("Tcp线程池创建完成");
        log.info("Tcp" + Thread.currentThread().getName());
        ExecutorService tcp = new ThreadPoolExecutor(75, 100,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        log.info("Http线程池创建完成");
        log.info("Http" + Thread.currentThread().getName());
        threadPools.put("HttpPools", http);
        threadPools.put("TcpPools", tcp);
    }

    /**
     * Gets the value of threadPools. *
     *
     * @return the value of threadPools
     */
    public static HashMap<String, ExecutorService> getThreadPools() {
        return threadPools;
    }
}
