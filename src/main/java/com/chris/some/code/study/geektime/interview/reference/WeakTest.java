package com.chris.some.code.study.geektime.interview.reference;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * 弱引用测试
 *
 * @author chris
 */
public class WeakTest {

    static class WeakObject {
    }

    public static void main(String[] args) throws InterruptedException {
        WeakReference<WeakObject> weakReference = new WeakReference<>(new WeakObject());

        System.out.println(weakReference.get() == null); // false

        System.gc();
        TimeUnit.SECONDS.sleep(1); // 暂停1秒

        System.out.println(weakReference.get() == null); // true
    }
}
