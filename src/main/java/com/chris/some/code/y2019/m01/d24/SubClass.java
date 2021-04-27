package com.chris.some.code.y2019.m01.d24;

public class SubClass extends AbstractClass {
    @Override
    String test() {
        return null;
    }

    @Override
    String test(String str) {
        System.out.println(str);
        return str;
    }
}
