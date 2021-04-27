package com.chris.some.code.y2019.m01.d22;

import java.util.UUID;

/**
 * @author Alex
 */
public class TestMyArrayList {
    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.add("宁小葱");
        System.out.println(myList);
        myList.set(0, "宁大葱");
        System.out.println(myList);
        System.out.println(myList.size());
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
