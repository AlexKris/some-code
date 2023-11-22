package com.chris.some.code.study.geektime.mathematics.chapter3;

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
 *     求数值的精确或近似解：二分法（Bisection method）和牛顿迭代法（Newton's method）
 *     在一定范围内查找目标值：二分查找
 *     机器学习算方中的迭代：K-均值算法（K-means clustering）、PageRank 的马尔科链（Markov chain）、梯度下降法（Gradient descent）
 * </pre>
 *
 * @author chris
 * @since 2023-11-13 17:24
 */
public class IterationTest {

    public static void main(String[] args) {
        System.out.printf("舍罕王给了这么多粒：%d%n", getNumberOfWheat(63));
    }

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

}
