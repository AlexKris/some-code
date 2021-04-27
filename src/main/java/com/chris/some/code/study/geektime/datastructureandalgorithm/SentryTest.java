package com.chris.some.code.study.geektime.datastructureandalgorithm;

/**
 * 测试哨兵在实际代码中的应用
 * <p>
 * 在数组中查找key，返回key所在位置
 * ints = {4,2,3,5,9,6},key = 7
 * ints = {4,2,3,5,9,6},key = 6
 */
public class SentryTest {
    private static int findWithoutSentry(int[] ints, int key) {
        if (ints == null || ints.length <= 0) {
            return -1;
        }

        int i = 0;
        while (i < ints.length) {
            if (ints[i] == key) {
                return i;
            }
            ++i;
        }

        return -1;
    }

    private static int findWithSentry(int[] ints, int key) {
        if (ints == null || ints.length <= 0) {
            return -1;
        }

        if (ints[ints.length - 1] == key) {
            return ints.length - 1;
        }

        int c = ints[ints.length - 1];
        // 哨兵
        ints[ints.length - 1] = key;

        int i = 0;
        while (ints[i] != key) {
            ++i;
        }

        ints[ints.length - 1] = c;

        if (i == ints.length - 1) {
            return -1;
        } else {
            return i;
        }
    }
}
