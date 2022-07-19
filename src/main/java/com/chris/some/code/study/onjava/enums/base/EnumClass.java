package com.chris.some.code.study.onjava.enums.base;

/**
 * enum 类自动继承 java.lang.Enum
 * <pre>
 *     1. ordinal() 方法返回一个从 0 开始的 int 值，代表每个枚举实例生命顺序
 *     2. 可以使用 == 比较枚举实例
 *     3. compareTo()
 *     4. 实现了 Serializable，可以序列化
 *     5. getDeclaringClass() 方法，获得该枚举实例所属的外部包装类
 *     6. name() 枚举实例被声明的名称
 *     7. toString 枚举实例被声明的名称
 *     8. valueOf() Enum 的静态方法，根据传入的 String，返回名称与该 String 匹配的枚举实例，如果不存在则抛出异常
 * </pre>
 *
 * @author grt
 * @since 2022-07-19 16:24:01
 */
public class EnumClass {

    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            int ordinal = s.ordinal();
            System.out.println("ordinal = " + ordinal);
            int compare = s.compareTo(Shrubbery.CRAWLING);
            System.out.println("compare = " + compare);
            boolean equals = s.equals(Shrubbery.CRAWLING);
            System.out.println("equals = " + equals);
            boolean b = s == Shrubbery.CRAWLING;
            System.out.println("b = " + b);
            Class<Shrubbery> declaringClass = s.getDeclaringClass();
            System.out.println("declaringClass = " + declaringClass);
            String name = s.name();
            System.out.println("name = " + name);
        }
        for (String s : "GROUND CRAWLING HAVING".split(" ")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println("shrubbery = " + shrubbery);
        }
    }
}

