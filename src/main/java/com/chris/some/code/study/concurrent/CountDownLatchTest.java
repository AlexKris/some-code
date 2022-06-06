package com.chris.some.code.study.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * {@link CountDownLatch}
 * 闭锁，让一组线程等待其他线程完成工作后才执行
 * <pre>
 *     new CountDownLatch(int count)，构造函数，参数count为扣减次数
 *     count可以大于等于线程个数，因为由第三方控制，可以扣减多次
 *     await，等待方法，带参数的为超时方法
 *     countDown，扣减count，每次扣减1
 *     getCount，获取当前count值
 * </pre>
 *
 * @author grt
 */
public class CountDownLatchTest {

    /**
     * 6个扣除点
     */
    static CountDownLatch countDownLatch = new CountDownLatch(6);

    /**
     * 初始化线程
     */
    private static class InitThread implements Runnable {
        @Override
        public void run() {
            System.out.println("thread_" + Thread.currentThread().getId() + " ready init work ...");

            // 执行扣减，扣减不代表结束
            countDownLatch.countDown();

            for (int i = 0; i < 2; i++) {
                System.out.println("thread_" + Thread.currentThread().getId() + " ... continue do its work");
            }
        }
    }

    private static class BizThread implements Runnable {
        @Override
        public void run() {
            try {
                countDownLatch.await();
                for (int i = 0; i < 3; i++) {
                    System.out.println("BizThread " + Thread.currentThread().getId() + " do ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        // 创建单独的初始化线程
        new Thread(() -> {
            SleepTools.milliSecond(1);
            System.out.println("thread_" + Thread.currentThread().getId() + " ready init work step 1st ...");
            // 扣减一次
            countDownLatch.countDown();
            System.out.println("begin stop 2nd ...");
            SleepTools.milliSecond(1);
            System.out.println("thread_" + Thread.currentThread().getId() + " ready init work step 2nd ...");
            // 扣减一次
            countDownLatch.countDown();
        }).start();

        // 启动业务线程
        new Thread(new BizThread()).start();
        // 启动初始化线程
        for (int i = 0; i <= 3; i++) {
            new Thread(new InitThread()).start();
        }

        // 主线程进入等待
        try {
            countDownLatch.await();
            System.out.println("Main do it's work");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
