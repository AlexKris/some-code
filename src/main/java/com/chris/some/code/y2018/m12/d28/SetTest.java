package com.chris.some.code.y2018.m12.d28;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        People people = new People();
        people.setName("宁");
        people.setAge(25);
        System.out.println(people.hashCode());
        System.out.println(people.toString());

        People people1 = new People();
        people1.setName("宁");
        people1.setAge(25);
        System.out.println(people1.hashCode());
        System.out.println(people1.toString());

        System.out.println(people.equals(people1));

        Set<People> set = new HashSet<>(4);
        set.add(people);
        set.add(people1);
        System.out.println(set);
    }
}