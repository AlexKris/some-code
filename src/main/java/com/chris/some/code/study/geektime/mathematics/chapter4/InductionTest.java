package com.chris.some.code.study.geektime.mathematics.chapter4;

import com.chris.some.code.study.geektime.mathematics.chapter3.IterationTest;

/**
 * 数学归纳法（Mathematical Induction）
 * <p>棋盘麦粒问题</p>
 * <pre>
 *     第1格到第8格的麦粒数量分别是：1、2、4、8、16、32、64、128
 *     前两格：3 = 2^2 - 1
 *     前三格：7 = 2^3 - 1
 *     前八格：255 = 2^8 - 1
 *     前n格：2^n -1
 * </pre>
 * <p>对于类似这种无穷数列的问题，通常可以采用数学归纳法进行证明</p>
 * <pre>
 *     数论中，数学归纳法用来证明任意一个给定的情形都是正确的，即：第一个、第二个、第三个、直到所有情形，概不例外
 *     1、证明基本情况（通常是n=1时）是否成立
 *     2、假设n=k-1成立，再证明n=k也是成立的（k为任意大于1的自然数）
 * </pre>
 * <p>麦粒问题证明</p>
 * <pre>
 *     1、第n个格子放的麦粒为2^(n-1)
 *     2、前n个格子放的麦粒总数为2^n - 1
 * </pre>
 * <p>数学归纳法和递归调用</p>
 * <pre>
 *     1、如果n为1，判断麦粒总数为2^(1-1)=1
 *     2、如果n为k-1时成立，则判断n为k也成立
 *     通过递归调用将2回退到n=1的情况
 *     函数从k=63开始调用，然后调用k-1，直到k=1，嵌套调用结束，k=1的函数开始返回值给k=2的函数，直到k=63的函数
 *     从k=63、62、...、2、1的嵌套调用过程，体现了数学归纳法的核心：逆向递推
 *     从k=1、2、...、62、63的值返回过程，和基于循环的迭代一致：正向递推
 * </pre>
 *
 * @author chris
 * @since 2023-12-11 14:53
 */
public class InductionTest {

    public static void main(String[] args) {
        int grid = 63;
        long start, end = 0;
        start = System.currentTimeMillis();
        System.out.printf("舍罕王给了这么多粒：%d%n", IterationTest.getNumberOfWheat(grid));
        end = System.currentTimeMillis();
        System.out.printf("迭代法耗时%d毫秒%n", (end - start));

        start = System.currentTimeMillis();
        System.out.printf("舍罕王给了这么多粒：%d%n", (long) (Math.pow(2, grid)) - 1);// 存在精度问题，比真实差1
        end = System.currentTimeMillis();
        System.out.printf("数学归纳法耗时%d毫秒%n", (end - start));

        WheatResult result = new WheatResult();
        System.out.println(prove(grid, result));
    }

    static class WheatResult {
        /**
         * 当前格子麦粒数
         */
        public long wheatNum = 0;
        /**
         * 当前格子麦粒总数
         */
        public long wheatTotalNum = 0;
    }

    /**
     * 使用函数的递归（嵌套）调用，进行数学归纳法证明
     *
     * @param k      第几格
     * @param result 保存当前格子的麦粒数和麦粒总数
     * @return {@link boolean} 放到第k格时是否成立
     */
    public static boolean prove(int k, WheatResult result) {
        // 证明n=1时，命题是否成立
        if (k == 1) {
            if ((Math.pow(2, 1) - 1) == 1) {
                result.wheatNum = 1;
                result.wheatTotalNum = 1;
                return true;
            } else {
                return false;
            }
        } else {
            // 如果n=k-1时命题成立，证明n=k时命题是否成立
            boolean proveOfPreviousOne = prove(k - 1, result);
            result.wheatNum *= 2;
            result.wheatTotalNum += result.wheatNum;
            boolean proveOfCurrentOne = result.wheatTotalNum == (Math.pow(2, k) - 1);
            return proveOfPreviousOne && proveOfCurrentOne;
        }
    }
}
