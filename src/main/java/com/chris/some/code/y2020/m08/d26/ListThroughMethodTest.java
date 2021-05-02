package com.chris.some.code.y2020.m08.d26;

import java.util.ArrayList;
import java.util.List;

public class ListThroughMethodTest {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        testMethod(strings);
        System.out.println(strings);
    }

    public static void testMethod(List<String> strings) {
        strings.add("01");
    }
}
