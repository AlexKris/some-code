package com.chris.some.code.y2018.m10.d24;

import java.util.HashMap;
import java.util.Map;

public class TestMapNullValue {
    public static void main(String[] args) {
        String car = "兰博基尼";
        String veh = null;
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("car", car);
        String param = "car=" + (paramMap.get("car"))
                + "&veh=" + (paramMap.get("veh"));
        System.out.println(param);
    }
}
