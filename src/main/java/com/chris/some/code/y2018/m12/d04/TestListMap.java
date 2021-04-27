package com.chris.some.code.y2018.m12.d04;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestListMap {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("i", "9132.1564");
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map);
        BigDecimal n = new BigDecimal((String) list.get(0).get("i"));
        System.out.println(n);
    }
}
