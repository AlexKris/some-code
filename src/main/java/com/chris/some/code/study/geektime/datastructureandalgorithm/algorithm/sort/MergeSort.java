package com.chris.some.code.study.geektime.datastructureandalgorithm.algorithm.sort;

/**
 * 归并排序：如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了。
 * 分治思想：将一个大的问题分解成小的子问题来解决
 * 分治算法一般使用递归来实现
 * 分治是思想，递归是编程技巧
 * 递推公式：merge_sort(p...r) = merge(merge_sort(p...q), merge_sort(q...r))
 * 终止条件：p >= r 不用再继续分解
 *
 * @author chris
 */
public class MergeSort {

    private static void mergeSort(int[] arrays) {
        if (0 == arrays.length) return;
        mergeSort(arrays, 0, arrays.length - 1);
    }

    private static void mergeSort(int[] arrays, int startIndex, int endIndex) {
        // 递归终止条件
        if (startIndex >= endIndex) return;

        // 取startIndex到endIndex的中间位置
        int middleIndex = (endIndex + startIndex) / 2;

        // 分治递归
        mergeSort(arrays, startIndex, middleIndex);
        mergeSort(arrays, middleIndex + 1, endIndex);

        // 将两个已经有序的数组合并
        merge(arrays, startIndex, middleIndex, endIndex);
    }

    private static void merge(int[] arrays, int startIndex, int middleIndex, int endIndex) {
        int i = startIndex;
        int j = middleIndex + 1;
        int k = 0;
        // 申请大小为 endIndex - startIndex 的数组
        int[] tmp = new int[endIndex - startIndex];
        while (j <= middleIndex && j <= endIndex) {
            if (arrays[i] <= arrays[j]) {
                tmp[k++] = arrays[i++];
            } else {
                tmp[k++] = arrays[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = middleIndex;
        if (j <= endIndex) {
            start = j;
            end = endIndex;
        }

        // 将剩余的数据拷贝到临时数组 tmp
        while (start <= end) {
            tmp[k++] = arrays[start++];
        }

        // 将 tmp 中的数组拷贝回 arrays
        for (i = 0; i <= endIndex - startIndex; ++i) {
            arrays[startIndex + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
    }
}
