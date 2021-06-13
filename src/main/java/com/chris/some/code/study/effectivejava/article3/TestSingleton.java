package com.chris.some.code.study.effectivejava.article3;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * 3、使用私有构造方法或枚类实现 Singleton 属性
 */
public class TestSingleton {
    public static void main(String[] args) {
        // AccessibleObject.setAccessible
        Method[] methods = Elvis.INSTANCE.getClass().getDeclaredMethods();
        AccessibleObject.setAccessible(methods, true);
        for (Method method : methods) {
            System.out.println(method.toGenericString());
        }

        ElvisEnum.INSTANCE.leaveTheBuilding();
    }
}
