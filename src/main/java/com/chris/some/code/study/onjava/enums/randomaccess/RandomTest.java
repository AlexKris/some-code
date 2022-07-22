package com.chris.some.code.study.onjava.enums.randomaccess;

/**
 * @author grt
 * @since 2022-07-22 15:59:48
 */
public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(Enums.random(Activity.class) + " ");
        }
    }
}
