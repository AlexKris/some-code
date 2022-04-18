package com.chris.some.code.study.geektime.datastructureandalgorithm.datastructure.stack;

/**
 * 基于数组实现的顺序栈
 */
public class ArrayStack {

    // 数组
    private String[] items;
    // 栈中元素个数
    private int count;
    // 栈大小
    private int n;

    // 初始化数组，申请一个大小为n的数组空间
    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    // 入栈操作
    public boolean push(String item) {
        // 数组空间不够了，直接返回false，入栈失败。
        if (count == n) return false;
        // 将item放到下标为count的位置，并且count+1
        items[count++] = item;
        return true;
    }

    // 出栈操作
    public String pop() {
        // 如果栈为空，直接返回null
        if (count == 0) return null;
        // 返回下标为count-1的数组元素，并且栈中元素个数count-1
        return items[count--];
    }
}
