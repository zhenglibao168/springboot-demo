package cn.zlb.collection;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * map
 *
 * @author libao.zheng
 * @date 2020/7/21 7:14 下午
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> hashtable = new Hashtable<>();
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        Map<String, String> treeMap = new TreeMap<>(StringUtils::compare);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                concurrentHashMap.put("key" + UUID.randomUUID().toString(), UUID.randomUUID().toString());
            }).start();
        }
      // System.out.println("concurrentHashMap put total cost time:" + (System.currentTimeMillis() - startTime) + " ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                concurrentHashMap.put("key" + UUID.randomUUID().toString(), UUID.randomUUID().toString());
            }).start();
        }
      // System.out.println("concurrentSkipListMap put total cost time:" + (System.currentTimeMillis() - startTime) + " ms");
    }

}
