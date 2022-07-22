package com.chris.some.code.study.onjava.enums.values;

/**
 * getEnumConstants() 方法是 Class 类的方法
 * 没有枚举的类也可以使用，但是会返回 null，如果尝试引用结果，会抛出 NPE
 *
 * @author grt
 * @since 2022-07-22 15:22:46
 */
public class NonEnum {

    public static void main(String[] args) {
        Class<Integer> integerClass = Integer.class;
        try {
            for (Integer enumConstant : integerClass.getEnumConstants()) {
                System.out.println("enumConstant = " + enumConstant);
            }
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }
}
