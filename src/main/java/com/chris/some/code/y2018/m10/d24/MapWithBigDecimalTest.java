package com.chris.some.code.y2018.m10.d24;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MapWithBigDecimalTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("seq", "201810170222788");
        String seq = (String) map.get("seq");
        BigDecimal bigSeq = new BigDecimal(seq);
        System.out.println(bigSeq.toString());
    }
}
