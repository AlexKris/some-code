package com.chris.some.code.study.onjava.enums.polymorphism;

import java.util.function.Supplier;

/**
 * 所有 enum 类都继承 Enum，Java 不支持多继承，所以无法通过继承方式创建枚举对象
 * 可以创建实现一个或多个接口的枚举类型
 *
 * @author grt
 * @since 2022-07-22 15:36:04
 */
public class EnumImplementation {

    public static <T> void printNext(Supplier<T> rg) {
        System.out.print(rg.get() + ", ");
    }

    public static void main(String[] args) {
        // 选择一个实例
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
