package com.chris.some.code.y2020.m09.d15;

import lombok.var;

import java.util.StringJoiner;

public class TestJoiner {
    public static void main(String[] args) {
        var joiner = new StringJoiner(",");
        System.out.println("joiner.toString() = " + joiner.toString());
    }
}
