package com.chris.some.code.leetcode.y2021.m03.d31;

/**
 * 整数反转
 */
public class Q7 {
    public static void main(String[] args) {
//        System.out.println(reverse1(1463847412));
        System.out.println(reverse2(1534236469));
    }

    public static int reverse1(int x) {
        int i = 0;
        if (x < 0) {
            i = 1;
        }
        char[] chars = String.valueOf(x).toCharArray();
        char c;
        for (int j = chars.length - 1; i < j; i++, j--) {
            c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }
        String s = String.valueOf(chars);
        long l = Long.parseLong(s);
        if (l > 0x7fffffff || l < 0x80000000) {
            return 0;
        } else {
            return (int) l;
        }
    }

    // 1534236469
    public static int reverse2(int x) {
        long i = 0;
        while (x != 0) {
            i = i * 10 + x % 10;
            x = x / 10;
        }
        if (i > 0x7fffffff || i < 0x80000000) {
            return 0;
        }
        return (int) i;
    }
}
