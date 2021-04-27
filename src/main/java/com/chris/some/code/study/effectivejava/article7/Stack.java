package com.chris.some.code.study.effectivejava.article7;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 一个栈先增长，然后再收缩，从栈中弹出来的对象将不会被当作垃圾回收，
 * 即使使用栈的程序不再引用这些对象，它们也不会被回收，
 * 因为栈内部维护着对这些对象的过期引用，即：永远不会再被解除的引用
 * <p>
 * 凡是在elements数据的"活动部分"之外的任何引用都是过期的，
 * 活动部分指elements中下标小于size的那些元素
 */
// Can you spot the "memory lead"?
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element,
     * roughly doubling the capacity each time the array needs to grow
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
