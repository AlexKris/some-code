package com.chris.some.code.study.concurrent;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * {@link CyclicBarrier}
 * 栅栏锁，让一组线程到达某个屏障，被阻塞，直到组内最后一个线程到达，然后所有线程继续运行
 * <pre>
 *     new CyclicBarrier(int parties, Runnable barrierAction)，构造函数，parties参数为执行线程个数，barrierAction参数是当屏障开放后执行的任务线程
 *     parties一定等于线程个数，因为由一组线程自身控制
 * </pre>
 *
 * @author grt
 */
public class CyclicBarrierTest {

    /**
     * 存放子线程工作结果的安全容器
     */
    private static final ConcurrentHashMap<String, Long> resultMap = new ConcurrentHashMap<>();

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new CollectThread());

    /**
     * 结果打印线程
     * 用来演示CyclicBarrier的第二个参数，barrierAction
     */
    private static class CollectThread implements Runnable {

        @Override
        public void run() {
            StringBuilder result = new StringBuilder();
            for (Map.Entry<String, Long> workResult : resultMap.entrySet()) {
                result.append("[").append(workResult.getValue()).append("]");
            }
            System.out.println("result = " + result);
            System.out.println("do other business ...");
        }
    }

    /**
     * 工作子线程
     * 用于CyclicBarrier的一组线程
     */
    private static class SubThread implements Runnable {

        @Override
        public void run() {

            // 获取当前线程的ID
            long id = Thread.currentThread().getId();

            // 放入统计容器中
            resultMap.put(String.valueOf(id), id);

            try {
                Random random = new Random();
                if (random.nextBoolean()) {
                    Thread.sleep(1000 + id);
                    System.out.println("Thread_" + id + " ...... do something");
                }
                System.out.println(id + " is await");
                cyclicBarrier.await();
                Thread.sleep(1000 + id);
                System.out.println("Thread_" + id + " ...... do its business");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 4; i++) {
            Thread thread = new Thread(new SubThread());
            thread.start();
        }
    }
}
