package com.chris.some.code.y2024.m05;

public class TimeReplaceTest {

    public static void main(String[] args) {
        String datetime = "2023-10-12 14:16:00";
        String text = datetime.replaceAll("-", "").substring(0, 17) + "--";
        System.out.println("text = " + text);
    }
}
