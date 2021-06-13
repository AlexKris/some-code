package com.chris.some.code.study.effectivejava.article4;

// Non instantiable utility class

/**
 * 4、使用私有构造方法执行非实例化
 * <p>
 * 只包含静态方法和静态属性的类
 * <pre>
 *     可以用来按照 {@link java.lang.Math} 或 {@link java.util.Arrays} 的方式，把基本类型的值或数组类型上相关的方法组织起来；
 *     也可以通过 {@link java.util.Collections} 的方式，把实现特定接口上面的静态方法进行分组，包括工厂方法。
 * </pre>
 */
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }

    // Remainder omitted
}
