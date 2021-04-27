package com.chris.some.code.study.geektime.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 final
 * <p>
 * 想要实现一个一成不变的类
 * <pre>
 *     1、将 class 声明为 final
 *     2、将所有成员变量定义为 private 和 final，并且不实现 setter 方法
 *     3、构造对象时，成员变量使用深拷贝来初始化，而非直接赋值
 *     4、如果确实需要实现 getter 方法，或者其他可能返回内部状态的方法，使用 copy on write 原则，创建私有的 copy
 * </pre>
 *
 * @author chris
 */
public class FinalTest {

    public static void main(String[] args) {
        final List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("world");
        // final 并非一成不变 final 执行约束 strList 这个变量不能执行新的内存地址
        System.out.println(strList);
    }
}
