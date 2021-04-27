package com.chris.some.code.y2019.m01.d18;

import com.chris.some.code.y2018.m12.d28.People;

import java.util.HashMap;
import java.util.Map;

public class TestPass {
    public static void main(String[] args) {
        People people = new People();
        Map<String, Object> map = new HashMap<>(16);
        StringBuilder stringBuilder = new StringBuilder();
        testPass(people, map, stringBuilder);
        System.out.println(people);
        System.out.println(map);
        System.out.println(stringBuilder);
    }

    private static void testPass(People people, Map<String, Object> map, StringBuilder stringBuilder) {
        people = (People) test();
        map.put("01", "主申请人");
        stringBuilder.append("05");
        System.out.println(people);
        System.out.println(map);
        System.out.println(stringBuilder);
    }

    private static Object test() {
        return new People("jack", 19);
    }
}
