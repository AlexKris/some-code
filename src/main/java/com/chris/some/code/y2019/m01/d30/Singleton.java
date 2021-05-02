package com.chris.some.code.y2019.m01.d30;

public class Singleton {

    /**
     * 声明为 private 避免调用默认构造方法创建对象
     */
    private Singleton() {
    }

    /**
     * 声明为private 表明静态内部该类只能在该 Singleton类中被访问
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }
}
