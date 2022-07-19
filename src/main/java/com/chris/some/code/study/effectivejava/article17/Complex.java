package com.chris.some.code.study.effectivejava.article17;

import java.math.BigDecimal;

/**
 * 17、使可变化性最小化
 * <p>
 * 每个对象中包含的所有信息都必须在创建该对象的时候就提供，在该对象整个生命周期（lifetime）内都固定不变
 * 例如：String、基本类型包装类、BigInteger、BigDecimal
 * <p>
 * 相比可变类的有点
 * 易于设计、实现和使用，不容易出错，更加安全。
 * <p>
 * 五条规则：
 * <pre>
 *     1、不要提供任何会修改对象状态的方法，setter
 *     2、保证类不会被扩展，防止被子类继承extends并修改，使用final修饰
 *     3、声明所有的域都是final的，防止直接修改
 *     4、声明所有的域都是私有的，private
 *     5、确保对于任何可变组件的互斥访问，如果类有指向可变对象的方法，确保无法通过该类获得指向可变对象的引用
 * </pre>
 *
 * @author grt
 */
public final class Complex {

    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public static void main(String[] args) {
        BigDecimal negate = new BigDecimal("10000").negate();
        System.out.println("negate = " + negate);
    }
}
