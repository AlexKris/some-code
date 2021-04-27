package com.chris.some.code.study.design.pattern.singleton;

/**
 * 单例
 * 枚举写法
 * 不需要自己考虑线程安全、懒加载
 * 防止序列化、反射破坏单例
 */
public enum SingletonEnum {
    INSTANCE;

    public void whateverMethod() {

    }
}
