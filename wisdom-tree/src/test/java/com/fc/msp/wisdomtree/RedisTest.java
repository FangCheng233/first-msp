package com.fc.msp.wisdomtree;

import javafx.scene.chart.ValueAxis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Set;

/**
 * @ClassName RedisTest
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/20 3:55 下午
 * @Version 1.0
 */
@SpringBootTest
public class RedisTest {


    private RedisTemplate redisTemplate;

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void test(){
        SetOperations<String, String> set = redisTemplate.opsForSet();
        set.add("set1","1");
        set.add("set2","2");
        set.add("set3","3");
        set.remove("set","33");
        Set<String> resultSet = redisTemplate.opsForSet().members("set1");
        System.out.println("resultSet:"+resultSet);
    }
}
