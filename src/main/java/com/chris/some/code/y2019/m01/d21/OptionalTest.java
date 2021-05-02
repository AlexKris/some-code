package com.chris.some.code.y2019.m01.d21;

import com.chris.some.code.y2018.m12.d28.People;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        testNullable();
        testOf();
    }

    private static void testNullable() {
        People people = null;
        People john = new People("john", 18);
        People dick = new People("dick", 12);

        System.out.println("orElse:" + Optional.ofNullable(people).orElse(john));
        System.out.println("get:" + Optional.ofNullable(john).get());
        System.out.println("orElse:" + Optional.ofNullable(dick).orElse(john));
        System.out.println("orElseGet:" + Optional.ofNullable(people).orElseGet(() -> john));
        System.out.println();
    }

    private static void testOf() {
        try {
            People people = new People();
            Optional<People> peopleOptional = Optional.of(people);
            if (peopleOptional.isPresent()) {
                System.out.println("people is not null");
            }
            People people1 = null;
            Optional<People> peopleOptional1 = Optional.of(people1);
            if (peopleOptional1.isPresent()) {
                System.out.println("people is not null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}