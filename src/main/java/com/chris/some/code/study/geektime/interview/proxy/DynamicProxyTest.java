package com.chris.some.code.study.geektime.interview.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 动态代理测试
 * <p>
 * JDK Proxy 以接口为纽带
 * <p>
 * JDK Proxy 优势
 * <pre>
 *     1、最小化依赖关系，简化开发和维护
 *     2、平滑进行 JDK 版本升级
 *     3、代码实现简单
 * </pre>
 * cglib 采取创建目标类的子类
 * <p>
 * cglib 优势
 * <pre>
 *     1、没有必需实现接口的限制
 *     2、只操作关心的类，不必为其他相关类增加工作量
 *     3、高兴嫩
 * </pre>
 *
 * @author chris
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        // 未代理的方法
        hello.sayHello();
        TestHandler handler = new TestHandler(hello);
        // 构造代码实例
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), handler);
        // 调用代理方法
        proxyHello.sayHello();
    }
}

interface Hello {
    void sayHello();
}

class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("Hello world");
    }
}

class TestHandler implements InvocationHandler {

    private final Object target;

    public TestHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking sayHello");
        return method.invoke(target, args);
    }
}
