package com.chris.some.code.y2019.m06.d03.testinterface;

public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
