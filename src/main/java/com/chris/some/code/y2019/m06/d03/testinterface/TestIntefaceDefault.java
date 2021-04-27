package com.chris.some.code.y2019.m06.d03.testinterface;

public class TestIntefaceDefault {
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        double calculate = formula.calculate(100);
        System.out.println("calculate:" + calculate);
        double sqrt = formula.sqrt(16);
        System.out.println("sqrt:" + sqrt);
    }
}
