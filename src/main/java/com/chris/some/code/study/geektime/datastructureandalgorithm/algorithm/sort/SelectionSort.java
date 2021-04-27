package com.chris.some.code.study.geektime.datastructureandalgorithm.algorithm.sort;

/**
 * <p>选择排序</p>
 * <p>1、选择排序空间复杂度是O(1)。原地排序算法。</p>
 * <p>2、由于交换位置。不是稳定的排序算法。</p>
 * <p>3、最好时间复杂度是O(n^2)；最坏时间复杂度是O(n^2)；平均时间复杂度是O(n^2)。</p>
 *
 * @author grt
 */
public class SelectionSort {
    public static void main(String[] args) {
    }

    private static void selectionSort(int[] a) {
        if (a.length <= 1) return;

        for (int i = 0; i < a.length - 1; i++) {
            int min = i;

            // 查找最小值
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    // 记录最小值元素下标
                    min = j;
                }
            }

            // 交换
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }
}
