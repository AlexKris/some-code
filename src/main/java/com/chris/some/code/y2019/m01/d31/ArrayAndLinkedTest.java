package com.chris.some.code.y2019.m01.d31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayAndLinkedTest {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>(6);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        List<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add("6");
        linkedList.add("7");
        List<String> list = new ArrayList<>(arrayList);
        List<String> list1 = new LinkedList<>(linkedList);
        System.out.println(arrayList);
        System.out.println(list);
        System.out.println(list1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(2 >> 1);
        System.out.println(arrayList.indexOf("4"));
        String[] strings = new String[]{};
        String[] array = arrayList.toArray(strings);
        System.out.println(Arrays.toString(array));
        System.out.println("Before add:arrayList.size() = " + arrayList.size());
        System.out.printf("Before add:arrayList.size() = %d\n", arrayList.size());
        String[] strings1 = arrayList.toArray(new String[0]);
        System.out.println(Arrays.toString(strings1));
    }
}
