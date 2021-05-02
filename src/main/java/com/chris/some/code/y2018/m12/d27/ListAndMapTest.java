package com.chris.some.code.y2018.m12.d27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试集合
 *
 * @author chris
 */
public class ListAndMapTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(3);
        list.add("String1");
        list.add("String2");
        list.set(0, "String");
        boolean emptyFlag = list.isEmpty();
        System.out.println(emptyFlag);
        System.out.println(list);
        list.clear();
        System.out.println(list);
        Map<String, Object> map = new HashMap<>(4);
        map.put("1", "o1");
        map.put("2", "o2");
        System.out.println(map);
        map.clear();
        System.out.println(map);
    }
}
