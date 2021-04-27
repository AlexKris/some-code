package com.chris.some.code.y2019.m01.d16;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TestListAndListIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        System.out.println(list);
        list.add(0, "0");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.remove("7"));
        System.out.println(list);
        System.out.println(list.remove("7"));
        ListIterator<String> stringListIterator = list.listIterator();
        for (String aList : list) {
            System.out.println(aList);
        }
        while (stringListIterator.hasNext()) {
            System.out.println(stringListIterator.next());
        }
        while (stringListIterator.hasPrevious()) {
            System.out.println(stringListIterator.previous());
        }
    }
}
