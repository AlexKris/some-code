package com.chris.some.code.y2018.m10.d24;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TestMapBigDecimal {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("themisSeq", "201810170222788");
        String themisSeq = (String) map.get("themisSeq");
        BigDecimal bigDecimal = new BigDecimal(themisSeq);
        System.out.println(bigDecimal.toString());
    }
}
