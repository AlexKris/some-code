package com.chris.some.code.study.effectivejava.article1;

import lombok.Data;

/**
 * 静态工厂方法代替构造方法
 * from 类型转换方法 只有单个参数，返回该类型的一个相对应的实例
 * of 聚合方法 带有多个参数，返回该类型的一个实例，把它们合并起来
 * valueOf 比from和of更繁琐的一种替代方法
 * instance 返回的实例是通过方法的（如有）参数来描述的，但是不能说与参数具有同样的值
 * create\newInstance 想instance和getInstance一样，但create或者newInstance能够确保每次调用都返回一个新的实例
 * getType 像getInstance一样，但是在工厂方法处于不同的类中的时候使用
 * newType 像newInstance一样，但是在工厂方法处于不同的类中的时候使用
 * type getType和newType的简版
 */
@Data
public class StaticFactoryMethod {
    private String methodName;

    private StaticFactoryMethod(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 类型转换方法
     *
     * @param methodName
     * @return com.chris.springboot.efectivejava.article1.StaticFactoryMethod
     */
    public static StaticFactoryMethod from(String methodName) {
        return new StaticFactoryMethod(methodName);
    }

    /**
     * 聚合方法
     *
     * @param method
     * @param name
     * @return com.chris.springboot.efectivejava.article1.StaticFactoryMethod
     */
    public static StaticFactoryMethod of(String method, String name) {
        return new StaticFactoryMethod(method + name);
    }
}
