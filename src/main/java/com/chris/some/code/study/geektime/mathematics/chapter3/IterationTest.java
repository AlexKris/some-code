package com.chris.some.code.study.geektime.mathematics.chapter3;

import java.util.Arrays;

/**
 * 迭代法（Iterative Method）
 * <p>棋盘与麦子</p>
 * <pre>
 *     第一个格子放一粒麦子
 *     第二个格子放二粒麦子
 *     第三个格子放四粒麦子
 *     每一个格子比前一个格子多一倍麦子
 * </pre>
 * <p>迭代法应用</p>
 * <pre>
 *     1、求数值的精确或近似解：二分法（Bisection method）和牛顿迭代法（Newton's method）
 *     2、在一定范围内查找目标值：二分查找（查找的区间是有序的）
 *     3、机器学习算方中的迭代：K-均值算法（K-means clustering）、PageRank 的马尔科链（Markov chain）、梯度下降法（Gradient descent）
 * </pre>
 * <p>很多时候机器学习的过程，就是根据已知的数据和一定的假设，求一个局部最优解</p>
 * <p>1、求方程的精确或者近似解</p>
 * <pre>
 *     假设有正整数n（n>1），计算平方根，该平方根一定小于n大于1
 *     二分法：每次查看区间内中间值，检查是否符合标准
 * </pre>
 * <p>牛顿迭代法：以微分为基础，每次迭代的时候，找到比上一个值x_{0}更接近的方程的根，最终找到近似解</p>
 * <p>2、查找匹配记录</p>
 * <pre>
 *     自然语言处理中，处理同义词或近义词的扩展
 *     二分查找法进行字典查询：将整个字典先进行排序（假设从小到大），使用二分法逐步定位到被查找的单词，每次迭代都找到搜索区间的中间点，根据中间点判断选择左半边或右半边，直至范围缩小到单个的词
 * </pre>
 *
 * @author chris
 * @since 2023-11-13 17:24
 */
public class IterationTest {

    public static void main(String[] args) {
        // 计算到第 64 格，会超过 long 精度
        int grid = 63;
        System.out.printf("舍罕王给了这么多粒：%d%n", getNumberOfWheat(grid));

        // 计算平方根
        int number = 10;
        double squareRoot = getSquareRoot(number, 0.000001, 10000);
        if (squareRoot == -1.0) {
            System.out.println("请输入大于1的整数");
        } else if (squareRoot == -2.0) {
            System.out.println("未能找到解");
        } else {
            System.out.printf("%d的平方根是%f%n", number, squareRoot);
        }

        String[] dictionary = {"i", "am", "one", "of", "the", "authors", "in", "geek"};

        Arrays.sort(dictionary);

        String wordToFind = "i";

        boolean found = searchDict(dictionary, wordToFind);
        if (found) {
            System.out.printf("找到了单词%s%n", wordToFind);
        } else {
            System.out.printf("未能找到单词%s%n", wordToFind);
        }
    }

    /**
     * 计算多少粒麦粒
     *
     * @param grid 格子数
     * @return {@link long} 麦粒总数
     */
    private static long getNumberOfWheat(int grid) {
        // 麦粒总数
        long sum = 0;
        // 当前格子麦粒数
        long numberOfWheatInGrid = 0;

        // 第一个格子麦粒数
        numberOfWheatInGrid = 1;
        sum += numberOfWheatInGrid;

        for (int i = 2; i <= grid; i++) {
            // 当前格子麦粒数量为前一个格子的 2 倍
            numberOfWheatInGrid *= 2;
            // 累计麦粒总数
            sum += numberOfWheatInGrid;
        }
        return sum;
    }

    /**
     * 计算大于1的正整数的平方根
     *
     * @param n              大于1的正整数
     * @param deltaThreshold 误差阈值
     * @param maxTry         二分查找的最大次数
     * @return {@link double} 平方根的解
     */
    private static double getSquareRoot(int n, double deltaThreshold, int maxTry) {
        if (n <= 1) {
            return -1.0;
        }

        double min = 1.0, max = (double) n;

        for (int i = 0; i < maxTry; i++) {
            double middle = (min + max) / 2;
            double square = middle * middle;
            double delta = Math.abs((square / n) - 1);
            if (delta <= deltaThreshold) {
                return middle;
            } else {
                if (square > n) {
                    max = middle;
                } else {
                    min = middle;
                }
            }
        }
        return -2.0;
    }

    /**
     * 查找某个单词是否在字典中出现
     *
     * @param dictionary 排序后的字典
     * @param wordToFind 待查单词
     * @return {@link boolean} 是否发现待查单词
     */
    private static boolean searchDict(String[] dictionary, String wordToFind) {
        if (dictionary == null) {
            return false;
        }

        if (dictionary.length == 0) {
            return false;
        }

        int left = 0, right = dictionary.length - 1;
        while (left <= right) {
            // 假设left和right都接近计算机系统设定的最大值，想加时会溢出，如果只加两者差值的一半，则不会超出两者较大的值，也就不会溢出了
            int middle = left + (right - left) / 2;
            if (dictionary[middle].equals(wordToFind)) {
                return true;
            } else {
                if (dictionary[middle].compareTo(wordToFind) > 0) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return false;
    }

}
