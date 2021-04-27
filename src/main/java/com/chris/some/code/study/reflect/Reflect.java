package com.chris.some.code.study.reflect;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取Class对象的四种方式
        // 1 不进行初始化
        Class<DemoOfReflect> demoOfReflectClass1 = DemoOfReflect.class;
        // 2 内部实际调用native方法forName0(className, true, ClassLoader.getClassLoader(caller), caller);
        Class<?> demoOfReflectClass2 = Class.forName("com.chris.some.code.study.reflect.DemoOfReflect");
        // 3 通过实例对象获取
        DemoOfReflect demoOfReflect = new DemoOfReflect();
        Class<? extends DemoOfReflect> demoOfReflectClass3 = demoOfReflect.getClass();
        // 4 通过类加载器传入路径 不会初始化
        Class<?> demoOfReflectClass4 = ClassLoader.getSystemClassLoader().loadClass("com.chris.some.code.study.reflect.DemoOfReflect");
    }
}
