package com.fc.msp.mspalert;

import org.junit.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TempTest
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/5 12:15 下午
 * @Version 1.0
 */
public class TempTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.forEach((method, mapping) -> {
            System.out.print(method);
            System.out.println(mapping);
        });
    }
    @Test
    public void TestspringVersionAndspringBootVersion (){
        String springVersion = SpringVersion.getVersion();
        String springBootVersion = SpringBootVersion.getVersion();
        System.out.println(springVersion + "    "   + springBootVersion);
    }
}
