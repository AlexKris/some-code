package com.chris.some.code.y2018.m09.d10;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试map.get(null)
 *
 * @author chris
 */
public class MapGetNullTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(8);
        map.put("CA", "1");
        map.put("ZHXT", "2");
        map.put("WZ", "3");
        map.put(null, null);
        System.out.println(map.get(null)); // null
        System.out.println(map.get("")); // null
    }
}
