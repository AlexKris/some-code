package com.chris.some.code.y2019.m01.d22;

import java.util.UUID;

/**
 * @author chris
 */
public class MyArrayListTest {

    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("宁小葱");
        System.out.println(myArrayList);
        myArrayList.set(0, "宁大葱");
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
