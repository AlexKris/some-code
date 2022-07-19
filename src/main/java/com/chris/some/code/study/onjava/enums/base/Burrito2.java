package com.chris.some.code.study.onjava.enums.base;

import static com.chris.some.code.study.onjava.enums.base.SpicinessEnum.*;

/**
 * 静态导入枚举类型
 * static import 将所有的枚举实例标识符都引入本地命名共建
 * 注：如果枚举定义在同一个文件中，或者定义在默认包中，无法使用该方式
 *
 * @author grt
 * @since 2022-07-19 16:22:52
 */
public class Burrito2 {

    SpicinessEnum degree;

    public Burrito2(SpicinessEnum degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito2{" +
                "degree=" + degree +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Burrito2(NOT));
        System.out.println(new Burrito2(MEDIUM));
        System.out.println(new Burrito2(HOT));
    }
}

