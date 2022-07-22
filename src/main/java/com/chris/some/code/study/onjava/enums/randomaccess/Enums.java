package com.chris.some.code.study.onjava.enums.randomaccess;

import java.util.Random;

/**
 * {@code <T extends Enum<T>> T}声明了 T 是一个枚举的实例
 * 通过传入的 {@code Class<T>}，使这个 class 对象变得可用
 *
 * @author grt
 * @since 2022-07-22 15:53:56
 */
public class Enums {

    private static final Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }
}
