package com.chris.some.code.y2018.m10.d26;

import java.util.HashMap;
import java.util.Map;

public class TestMapNullKeyValue {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(16);
        map.put(null, null);
        String nu = (String) map.get(null);
        System.out.println(nu);
    }
}
