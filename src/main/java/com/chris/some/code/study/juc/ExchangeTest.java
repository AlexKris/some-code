package com.chris.some.code.study.juc;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Exchanger;

/**
 * {@link Exchanger}
 * 交换器，在两个线程之间交换数据
 * 创建时需指定要交换数据类型的泛型
 *
 * @author grt
 */
public class ExchangeTest {

    private static final Exchanger<Set<String>> EXCHANGER = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(() -> {
            Set<String> aSet = new HashSet<>();
            aSet.add("A");
            aSet.add("B");
            aSet.add("C");
            try {
                Set<String> exchange = EXCHANGER.exchange(aSet);
                for (String s : exchange) {
                    System.out.println("aSet s = " + s);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            Set<String> bSet = new HashSet<>();
            bSet.add("1");
            bSet.add("2");
            bSet.add("3");
            try {
                Set<String> exchange = EXCHANGER.exchange(bSet);
                for (String s : exchange) {
                    System.out.println("bSet s = " + s);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
