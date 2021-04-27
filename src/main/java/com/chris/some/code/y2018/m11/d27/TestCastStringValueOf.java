package com.chris.some.code.y2018.m11.d27;

import java.util.HashMap;
import java.util.Map;

public class TestCastStringValueOf {
    public static void main(String[] args) {
        String str = null;
        Map map = new HashMap();
        System.out.println(str);
        System.out.println((String) map.get("veh"));
        System.out.println(map.get("veh"));
        System.out.println(str);
    }
}
