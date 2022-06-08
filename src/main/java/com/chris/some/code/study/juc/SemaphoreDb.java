package com.chris.some.code.study.juc;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * {@link Semaphore}
 * 使用信号量控制数据库的连接和释放
 *
 * @author grt
 */
public class SemaphoreDb {

    /**
     * 池容量
     */
    private static final int POOL_SIZE = 10;

    /**
     * useFul 代表可用连接
     * useLess 代表已用连接
     * 在连接池中不只有连接本身是资源，空闲也是资源，同样需要记录
     */
    private final Semaphore useful, useless;

    /**
     * 连接池
     */
    private static final LinkedList<Connection> POOL = new LinkedList<>();

    // 使用静态块初始化池
    static {
        for (int i = 0; i < POOL_SIZE; i++) {
            POOL.addLast(SqlConnection.fetchConnection());
        }
    }

    public SemaphoreDb() {
        // 初始可用的许可证等于池容量
        useful = new Semaphore(POOL_SIZE);
        // 初始已用的许可证容量为0
        useless = new Semaphore(0);
    }

    /**
     * 获取数据库连接
     *
     * @return 连接对象 {@link Connection}
     * @throws InterruptedException 异常
     */
    public Connection taskConnection() throws InterruptedException {
        // 可用许可证减1
        useful.acquire();
        Connection connection;
        synchronized (POOL) {
            connection = POOL.removeFirst();
        }
        // 已用的许可证数据量加1
        useless.release();
        return connection;
    }

    /**
     * 释放连接
     *
     * @param connection 连接对象 {@link Connection}
     * @throws InterruptedException 异常
     */
    public void returnConnection(Connection connection) throws InterruptedException {
        if (null == connection) {
            return;
        }
        System.out.println("当前有" + useful.getQueueLength() +
                "个线程等待获取连接，可用连接有" + useful.availablePermits() + "个");
        // 已用许可证减1
        useless.acquire();
        synchronized (POOL) {
            POOL.addLast(connection);
        }
        // 可用许可证加1
        useful.release();
    }
}
