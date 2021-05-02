package com.chris.some.code.y2018.m11.d27;

import java.util.HashMap;
import java.util.Map;

public class CastStringAndValueOfTest {

    public static void main(String[] args) {
        String str = null;
        Map<String, Object> map = new HashMap<>(2);
        System.out.println(str);
        System.out.println((String) map.get("veh"));
        System.out.println(map.get("veh"));
        System.out.println(str);
    }
}
