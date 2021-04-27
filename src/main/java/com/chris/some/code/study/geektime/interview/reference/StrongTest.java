package com.chris.some.code.study.geektime.interview.reference;

import java.util.concurrent.TimeUnit;

/**
 * 强引用测试
 *
 * @author chris
 */
public class StrongTest {

    public static void main(String[] args) throws InterruptedException {
        StrongTest strongTest = new StrongTest();

        System.gc();
        TimeUnit.SECONDS.sleep(1); // 暂停1秒

        System.out.println(strongTest == null); // false
    }
}
