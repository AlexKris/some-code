package com.chris.some.code.study.geektime.interview.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用测试
 * <p>
 * -Xms10m -Xmx10m
 *
 * @author chris
 */
public class SoftTest {

    static class HeapObject {
        byte[] bytes = new byte[1024 * 1024];
    }

    public static void main(String[] args) {
        SoftReference<HeapObject> softReference = new SoftReference<>(new HeapObject());

        List<HeapObject> list = new ArrayList<>();

        while (true) {
            if (softReference.get() != null) {
                list.add(new HeapObject());
                System.out.println("list.add");
            } else {
                System.out.println("软引用已被回收");
                break;
            }
            System.gc();
        }
    }
}
