package com.chris.some.code.leetcode.y2021.m03.d26;

/**
 * 问题344
 * 反转字符串
 * 指针碰撞
 */
public class Q344 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        char c;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
        System.out.println(s);
    }
}
