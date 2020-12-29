package com.fc.msp.mspmail.cache;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.ibatis.cache.Cache;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.*;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * @ClassName RedisCache
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/23 11:30 下午
 * @Version 1.0
 */

public class RedisCache implements Cache {

    /**
     * 序列化和反序列化的操作类
     * @author Administrator
     *
     */
    static class SeqUtils{

        /**
         * 对象序列化成字节数组
         * @param obj
         * @return
         * @throws IOException
         */
        public static byte[] ser(Object obj) throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream obos = new ObjectOutputStream(baos);
            obos.writeObject(obj);
            return baos.toByteArray();
        }

        /**
         * 反序列化为对象
         * @param bt
         * @return
         * @throws IOException
         * @throws ClassNotFoundException
         */
        static public Object deSer(byte[] bt) throws IOException, ClassNotFoundException{
            ByteArrayInputStream bais=new ByteArrayInputStream(bt);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        }
    }

    static JedisPool jp = null;
    private String id;

    public RedisCache(String id){
        if(jp==null){
            try {
                GenericObjectPoolConfig gopc = new GenericObjectPoolConfig();
                gopc.setMaxTotal(100);
                gopc.setMaxIdle(10);
                jp = new JedisPool(gopc, "192.168.1.103",16379,10000,null,3);
                //去数据库连接一下，这样出错就会抛异常
                Jedis jedis = jp.getResource();
                jp.returnResourceObject(jedis);
            } catch (Exception e) {
                //e.printStackTrace();
                jp = null;
            }
        }
        this.id=id;
    }

    public static void main(String[] args) {
        GenericObjectPoolConfig gopc = new GenericObjectPoolConfig();
        gopc.setMaxTotal(100);
        gopc.setMaxIdle(10);
        gopc.setMaxWaitMillis(60000);
        JedisPool jedisPool =  new JedisPool(gopc, "192.168.31.43",16379,60000,null,3);
        Jedis jedis = jedisPool.getResource();

    }
    /**
     * 清空所有的缓存
     */
    @Override
    public void clear() {
        Jedis jedis = jp.getResource();
        jedis.flushAll();
        jp.returnResourceObject(jedis);
    }

    /**
     * 返回当前的id
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * maBatis会自动调用该方法，判断返回值是否为null
     * 		如果为空就去数据查
     * 		不为空就直接返回缓存对象
     */
    @Override
    public Object getObject(Object key) {
        //从连接池中获取一条连接
        Jedis jedis = jp.getResource();
        try {
            byte[] bt = jedis.get(SeqUtils.ser(key));
            if(bt!=null){
                Object obj = SeqUtils.deSer(bt);
                //将redis对象回收到连接池中
                jp.returnResourceObject(jedis);
                return obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * non-block io	非阻塞式IO
     * 读写锁
     * 同一时间只能有一个线程访问
     */
    @Override
    public ReadWriteLock getReadWriteLock() {
        return new ReentrantReadWriteLock();
    }

    /**
     * 用于读取redis中缓存了多少元素
     */
    @Override
    public int getSize() {
        Jedis jedis = jp.getResource();
        Set<String> allElements = jedis.keys("*");
        return allElements.size();
    }

    /**
     * 第一次查询数据库后mybatis会自动调用该方法将数据写入缓存
     */
    @Override
    public void putObject(Object key, Object value) {
        Jedis jedis=jp.getResource();
        try {
            jedis.set(SeqUtils.ser(key), SeqUtils.ser(value),"NX".getBytes(),"PX".getBytes(),1000L);
            //将redis对象回收到连接池中
            jp.returnResourceObject(jedis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用了myBatis flush方法自动清空缓存
     * 		自动调用removeObject 需要从redis中删除该元素
     */
    @Override
    public Object removeObject(Object key) {
        Jedis jedis=jp.getResource();
        try {
            jedis.del(SeqUtils.ser(key));
            //将redis对象回收到连接池中
            jp.returnResourceObject(jedis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}