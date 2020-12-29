package com.fc.msp.config.threadpool;

import sun.nio.ch.ThreadPool;

import java.util.Properties;
import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolBean
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/20 9:16 下午
 * @Version 1.0
 */
public class ThreadPoolBean<T> {
    /**
     * @Description  线程池的属性
     */

    private String poolName;
    private long aliveTime;
    private int coreSize;
    private String id;
    private int maxSize;
    private int taskQueueSize = 2147483647;
    private String timeUnit = "SECONDS";
    private BlockingQueue<T> queue;
    private Properties properties;
    private int level;
    private ThreadFactory factory;

    public ThreadPoolBean(String poolName) {
        this.poolName = poolName;
    }
}
