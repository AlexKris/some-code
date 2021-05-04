package com.chris.some.code.study.geektime.interview.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用 LinkedHashMap 构建空间敏感的资源池
 *
 * @author chris
 * @see java.util.LinkedHashMap
 * @since 1.0
 */
public class LinkedHashMapSample {

    public static void main(String[] args) {
        LinkedHashMap<String, String> accessOrderedMap = new LinkedHashMap<String, String>(16, 0.75f, true) {
            // 实现自定义删除策略，否则行为就和普遍Map没有区别
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 3;
            }
        };

        accessOrderedMap.put("Project1", "Valhalla");
        accessOrderedMap.put("Project2", "Panama");
        accessOrderedMap.put("Project3", "Loom");

        accessOrderedMap.forEach((k, v) -> System.out.println(k + ":" + v));

        // 模拟访问
        accessOrderedMap.get("Project1");
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project3");

        System.out.println("Iterate over should be not affected:");

        accessOrderedMap.forEach((k, v) -> System.out.println(k + ":" + v));

        // 触发删除
        accessOrderedMap.put("Project4", "Mission Control");
        System.out.println("Oldest entry should be removed:");

        // 遍历顺序不变
        accessOrderedMap.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
