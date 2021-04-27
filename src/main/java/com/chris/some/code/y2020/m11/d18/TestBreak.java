package com.chris.some.code.y2020.m11.d18;

public class TestBreak {
    public static void main(String[] args) {
        String[] strings = {"0", "1", "2"};
        a:
        for (String s : strings) {
            switch (s) {
                case "0":
                    System.out.println("s = " + s);
                    break a;
            }
            System.out.println("s = " + s);
        }
    }
}
