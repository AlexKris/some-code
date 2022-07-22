package com.chris.some.code.study.onjava.enums.values;

import com.chris.some.code.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/**
 * values() 方法是由编译器添加的一个静态方法，valueOf() 同样
 * Enum 类的 valueOf() 方法有 2 个参数，而由编译器添加的 valueOf() 只有 1 个参数
 * Explore 枚举被编译器限定为 final 类
 * 由于类型擦除，反编译器无法获得 Enum 类的完整信息
 *
 * @author grt
 * @since 2022-07-22 14:03:49
 */
public class Reflection {

    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("____ Analyzing " + enumClass + " ____");
        System.out.println("Interfaces:");
        for (Type genericInterface : enumClass.getGenericInterfaces()) {
            System.out.println("genericInterface = " + genericInterface);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods:");
        Set<String> methods = new HashSet<>();
        for (Method method : enumClass.getMethods()) {
            methods.add(method.getName());
        }
        System.out.println("methods = " + methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum)?" + exploreMethods.contains(enumMethods));
        System.out.println("Explore.removeAll(Enum):");
        enumMethods.removeAll(enumMethods);
        System.out.println("exploreMethods = " + exploreMethods);
        OSExecute.command("javap -cp target/classes/com/chris/some/code/study/onjava/enums/values Explore");
    }
}
