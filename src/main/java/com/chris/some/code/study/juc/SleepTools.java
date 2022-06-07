package com.chris.some.code.study.juc;

import java.util.concurrent.TimeUnit;

/**
 * 线程休眠工具类
 *
 * @author grt
 */
public class SleepTools {

    /**
     * 按秒休眠
     *
     * @param seconds 秒
     */
    public static void second(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按毫秒休眠
     *
     * @param milliSeconds 毫秒
     */
    public static void milliSecond(int milliSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
