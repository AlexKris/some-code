package com.chris.some.code.y2018.m12.d04;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMapTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("i", "9132.1564");
        List<Map<String, Object>> list = new ArrayList<>(1);
        list.add(map);
        BigDecimal n = new BigDecimal((String) list.get(0).get("i"));
        System.out.println(n);
    }
}
