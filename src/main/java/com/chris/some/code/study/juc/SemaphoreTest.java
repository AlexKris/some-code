package com.chris.some.code.study.juc;

import java.sql.Connection;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * {@link Semaphore}
 *
 * @author grt
 */
public class SemaphoreTest {

    /**
     * 连接池
     */
    public static final SemaphoreDb POOL = new SemaphoreDb();

    private static class BizThread extends Thread {
        @Override
        public void run() {
            // 随机数，为了让每个线程持有连接的时间不一致
            Random random = new Random();
            long start = System.currentTimeMillis();
            try {
                Connection connection = POOL.taskConnection();
                System.out.println("Thread_" + Thread.currentThread().getId() +
                        "_获取数据库连接耗时[" + (System.currentTimeMillis() - start) + "]ms");
                // 模拟使用连接查询数据
                SleepTools.milliSecond(100 + random.nextInt(100));
                System.out.println("数据查询完成归还连接");
                POOL.returnConnection(connection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            BizThread bizThread = new BizThread();
            bizThread.start();
        }
    }
}
