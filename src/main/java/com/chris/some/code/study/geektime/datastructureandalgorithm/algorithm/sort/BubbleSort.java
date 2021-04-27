package com.chris.some.code.study.geektime.datastructureandalgorithm.algorithm.sort;

/**
 * <p>冒泡排序</p>
 * <p>1、只涉及相邻数据的交换操作，空间复杂度是O(1)。原地排序算法。</p>
 * <p>2、只有交换才会改变两个元素的前后顺序，为了保证冒泡排序算法的稳定性，当相邻两个元素大小相等时未做交换。稳定的排序算法。</p>
 * <p>3、假设数据已有序，只需进行一次冒泡操作，所以最好情况时间复杂度为O(n)；最坏情况刚好倒序，所以最坏时间复杂度为O(n^2)；</p>
 *
 * <p>有序度：数组中具有有序关系的元素对的个数，有序元素对：a[i] <= a[j]，如果i < j</p>
 * <p>例如：2,4,3,1,5,6的有序度是11，分别是(2,4),(2,3),(2,5),(2,6),(4,5),(4,6),(3,5),(3,6),(1,5),(1,6),(5,6)</p>
 * <p>完全有序的数组，例如：1,2,3,4,5,6的有序度就是 n * (n-1) / 2，即15，满有序度</p>
 *
 * <p>冒泡排序总共包含两个操作：比较、交换，每次交换，有序度+1，交换次数为逆有序度，即 n * (n-1) / 2 - 初始有序度</p>
 * <p>最好情况下，初始有序度为 n * (n-1) / 2，不需要进行交换</p>
 * <p>最坏情况下，初始有序度为 0，需要进行 n * (n-1) / 2 次交换</p>
 * <p>取中间值即为 n * (n-1) / 4，所以平均情况下，需要 n * (n-1) / 4 次交换，比较次数一定比交换次数对，而复杂度上限是O(n^2)，所以平均情况时间复杂度为O(^2)</p>
 *
 * @author grt
 */
public class BubbleSort {
    public static void main(String[] args) {
    }

    private static void bubbleSort(int[] a) {
        if (a.length <= 1) return;

        for (int i = 0; i < a.length; i++) {
            // 提前退出冒泡排序的标识位
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;// 表示有数据交换
                }
            }
            if (!flag) break;// 无数据交换，提前退出
        }
    }

    // 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,对于边界外的元素在下次循环中无需比较.
    private static void bubbleSort2(int[] a) {
        if (a.length <= 1) return;

        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界，每次只需比较到这里即可退出
        int sortBorder = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            // 提前退出冒泡排序的标识位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;// 表示有数据交换
                    lastExchange = j;// 更新最后一次交换的位置
                }
            }
            sortBorder = lastExchange;
            if (!flag) break;// 无数据交换，提前退出
        }
    }
}
