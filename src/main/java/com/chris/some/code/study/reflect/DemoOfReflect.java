package com.chris.some.code.study.reflect;

public class DemoOfReflect {
    private String value;

    public DemoOfReflect() {
        System.out.println("无参构造方法");
    }

    {
        System.out.println("非静态代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public DemoOfReflect(String value) {
        System.out.println("有参构造方法");
        this.value = value;
    }

    private static void staticMethod() {
        System.out.println("静态方法中的内容");
        {
            System.out.println("静态方法中的代码块");
        }
    }

    public void publicMethod(String s) {
        System.out.println("s = " + s);
    }

    private void privateMethod() {
        System.out.println("value = " + value);
    }
}
