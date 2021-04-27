package com.chris.some.code.study.geektime.interview.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用测试
 * <p>
 * 无法获取虚引用对象
 *
 * @author chris
 */
public class PhantomTest {

    static class PhantomObject {
    }

    public static void main(String[] args) {
        ReferenceQueue<PhantomObject> queue = new ReferenceQueue<>();
        PhantomReference<PhantomObject> phantomReference = new PhantomReference<>(new PhantomObject(), queue);

        System.out.println(phantomReference.get() == null); // true
    }
}
