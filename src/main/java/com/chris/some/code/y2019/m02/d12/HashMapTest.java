package com.chris.some.code.y2019.m02.d12;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>(4);
        map.put("1", "nxc");
        map.put("1", "jb");
        System.out.println(map);
        System.out.println(map.get("1"));
        System.out.println(1 << 4);
        System.out.println(1 << 30);
    }
}
