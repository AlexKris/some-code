package com.chris.some.code.study.geektime.concurrent;

import java.time.LocalTime;

/**
 * 并发编程测试
 * <p>
 * 并发编程bug起源：CPU速度 > 内存速度 > I/O设备速度
 * <p>
 * 目前解决方案
 * <p>1、CPU增加缓存，均衡与内存的速度差异</p>
 * <p>2、操作系统增加进程、线程，CPU分时复用，均衡与I/O设备的速度差异</p>
 * <p>3、编译程序优化指令执行次序，合理使用缓存</p>
 * 源头：
 * <p>1、缓存导致的可见性问题。t1线程和t2线程各自的CPU缓存中都缓存了count，两个线程分别根据自己缓存中的值计算。</p>
 * <p>2、线程切换带来的原子性问题。
 * count += 1;至少需要三条CPU指令，
 * 1:把变量count的值加载到CPU寄存器，
 * 2:在寄存器中执行+1操作，
 * 3:将结果写入内存（可能写入CPU缓存而非内存）</p>
 * <p>3、编译优化带来的有序性问题。
 * 双重检查单例模式，new对象时，
 * 我们以为的操作:1.分配一块内存M；2.在内存M上初始化Singleton对象；3.然后将M的地址赋值给instance变量，
 * 但是实际上:1.分配一块内存M，2.将M的地址赋值给instance变量，3.最后在内存M上初始化Singleton对象</p>
 *
 * @author chris
 */
public class ConcurrentTest {

    private long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public static long calc() throws InterruptedException {
        final ConcurrentTest test = new ConcurrentTest();
        // 创建两个线程，执行add()
        Thread t1 = new Thread(test::add10K);
        Thread t2 = new Thread(test::add10K);
        // 启动
        t1.start();
        t2.start();
        // 等待两个线程结束
        t1.join();
        t2.join();
        return test.count;
    }

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("now = " + now);

        String startTime = "11:00";
        LocalTime start = LocalTime.parse(startTime);
        System.out.println("parse = " + start);
        System.out.println(now.compareTo(start));

        String endTime = "10:00";
        LocalTime end = LocalTime.parse(endTime);
        System.out.println("parse = " + end);
        System.out.println(now.compareTo(end));
    }
}
