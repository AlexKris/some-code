package com.chris.some.code.y2019.m06.d03.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestLambda {
    public static void main(String[] args) {
        List<String> names1 = Arrays.asList("peter", "anna", "mike", "xenia");
        List<String> names2 = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names1, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println(names1);
        names2.sort(String::compareTo);
        System.out.println(names2);
    }
}
