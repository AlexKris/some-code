package com.chris.some.code.study.effectivejava.article1;

import lombok.Data;

/**
 * 1、考虑使用静态工厂方法替代构造方法
 * <p>优点：</p>
 * <pre>
 *     1、自定义名字，更易读。
 *     2、不需要每次调用时都创建一个新对象。允许不可变的类使用预先构建的实例，或在构造时缓存实例，并反复分配这些实例以避免创建不必要的重复对象。
 *     3、可以返回其返回类型的任何子类型对象。
 *     4、返回对象的类可以根据输入参数的不同而不同。
 *     5、编写包含该方法的类时，返回的对象的类不需要存在。
 * </pre>
 * <p>from 类型转换方法 只有单个参数，返回该类型的一个相对应的实例</p>
 * <p>of 聚合方法 带有多个参数，返回该类型的一个实例，把它们合并起来</p>
 * <p>valueOf 比from和of更繁琐的一种替代方法</p>
 * <p>instance 返回的实例是通过方法的（如有）参数来描述的，但是不能说与参数具有同样的值</p>
 * <p>create\newInstance 想instance和getInstance一样，但create或者newInstance能够确保每次调用都返回一个新的实例</p>
 * <p>getType 像getInstance一样，但是在工厂方法处于不同的类中的时候使用</p>
 * <p>newType 像newInstance一样，但是在工厂方法处于不同的类中的时候使用</p>
 * <p>type getType和newType的简版</p>
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
