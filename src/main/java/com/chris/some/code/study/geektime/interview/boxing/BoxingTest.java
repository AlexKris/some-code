package com.chris.some.code.study.geektime.interview.boxing;

/**
 * 自动拆装箱测试
 * <p>
 * Java 5 引入自动装箱和自动拆箱
 * <p>
 * 新增了静态工厂方法 valueOf()，调用时会利用缓存机制
 * <p>
 * Integer 默认缓存 -128 到 127 之间的数值
 * Boolean 缓存了 true 和 false，只会返回两个常量实例 Boolean.TRUE 和 Boolean.FALSE
 * Short 缓存了 -128 到 127 之间的数值
 * Byte 全部缓存
 * Character 缓存 \u0000 到 \u007F
 * <p>
 * JVM 提供了参数设置缓存上限 -XX:AutoBoxCacheMax=N
 * <p>
 * Java 对象的内存结构：
 * <p>
 * 1、对象头(Header)：一般十六个字节，包含两部分
 * <pre>
 *     Mark Word：对象自身的运行时数据，hashcode、GC年龄分代、锁状态标志、线程持有的锁、偏向线程ID、偏向时间戳，在32位和64位的JVM（未开启压缩指针）中分别为 32bit 和 64bit
 *     类型指针：对象指向它的类元数据的指针，虚拟机通过这个指针来确定这个对象时哪个类的实例
 * </pre>
 * 2、对象实例(Instance Data)：对象真正存储的有效信息，程序中定义的各种类型的字段内容，包括从父类继承的和子类自身定义的
 * <p>
 * 3、对齐填充(Padding)：非必然存在，起占位符的作用，因为 HotSpot JVM 的自动内存管理要求对象起始地址必须是8字节的整数倍，即对象大小必须是8字节的整数倍
 *
 * @author chris
 */
public class BoxingTest {

    public static void main(String[] args) {
        Integer integer = 1; // Integer.valueOf() 自动装箱
        int unboxing = integer++; // Integer.intValue() 自动拆箱
    }
}
