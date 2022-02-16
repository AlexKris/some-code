package com.chris.some.code.study.geektime.datastructureandalgorithm.datastructure.array;

/**
 * 数组
 * <p>
 * 编号从0开始
 * <p>
 * 特点：
 * <pre>
 *     1、线性表-数据排成像一条线一样的结构，每个数据最多只有前和后两个方向
 *     2、连续的内存空间和相同的数据类型-随机访问
 * </pre>
 * 寻址公式：a[i]_address = base_address + i * data_type_size
 * <p>
 * 时间复杂度分析
 * <pre>
 *     1、查找：时间复杂度不是O(1)；即使是排好序的数组，使用二分查找，时间复杂度也是O(logn)；所以数组根据下标随机访问的时间复杂度是O(1)
 *     2、插入：如果在数组末尾插入，不需要移动，时间复杂度是O(1)；如果在数组开头插入，所有元素都要依次向后移动一位，最坏时间复杂度是O(n)；在每个位置插入的概率相同，平均时间复杂度：(1+2+...+n)/n=O(n)
 *     3、删除：与插入相同，O(1)、O(n)、O(n)
 * </pre>
 * 数组删除元素时，不一定每次都真的删除，可以先记录已删除的数组，当数组空间不够时，再触发执行依次真正的删除操作，这就类似JVM垃圾回收的标记清除算法
 * <p>
 * 思考题：
 * <pre>
 *     1、JVM标记清楚垃圾回收算法
 *     2、二维数组的寻址公式
 * </pre>
 * JVM标记清楚垃圾回收算法：
 * <pre>
 *     1、大多数主流虚拟机采用可达性分析算法来判断对象是否存活，在标记阶段，会遍历所有 GC ROOTS，将所有 GC ROOTS 可达的对象标记为存活。只有当标记工作完成后，清理工作才会开始。
 *     2、不足：1.效率问题。标记和清理效率都不高，但是当知道只有少量垃圾产生时会很高效。2.空间问题。会产生不连续的内存空间碎片。
 * </pre>
 * 二维数组：a[m][n]，寻找a[i][j]（i < m，j < n）的地址：
 * <pre>
 *     二维数组内存寻址公式：a[i][j]_address = base_address + (i * n * data_type_size) + (j * data_type_size)
 *     (m * n)的二维数组取内存中(m * n) * data_type_size大小的内存存储数据，(i * n * data_type_size)找到第i行，(j * data_type_size)找到第i行上的第j列
 * </pre>
 */
public class ArrayStudy {
    public static void main(String[] args) {
        // 一维数组
        int[] a = new int[3];
        // 二维数组
        int[][] b = new int[3][];
        int[][] c = new int[3][3];
        int[][] d = new int[3][];// 初始化规定了行数，列长度每次变化都要重新申请空间
    }
}
