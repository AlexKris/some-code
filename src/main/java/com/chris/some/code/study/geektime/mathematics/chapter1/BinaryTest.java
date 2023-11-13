package com.chris.some.code.study.geektime.mathematics.chapter1;

import java.math.BigInteger;

/**
 * 二进制
 * <p>同十进制的基数为 10 一样</p>
 * <p>二进制的位数就是 2 ^ n 的形式</p>
 * <p>组成计算机系统的逻辑电路通常只有两个状态，即开关的接通与断开</p>
 * <pre>
 *     断开的状态用 0 表示，接通的状态用 1 表示
 * </pre>
 * <p>二进制位操作（位运算）</p>
 * <pre>
 *     向左移位：在末尾添加一位 0
 *     <pre>
 *         数字溢出：二进制的位数超过系统所指定的位数
 *         二进制左移一位：数字翻倍
 *     </pre>
 * </pre>
 * <pre>
 *     向右移位：数字除以 2 并求整数商
 *     <pre>
 *         位移 1 次，相当于乘以或除以 2，位移 3 次就相当于乘以或除以 8
 *         >> 也是右移
 *         Java 二进制数值中最高一位是符号位，当符号位 0 时表示该数值为正数，当符号位为 1 时表示该数值为负数
 *         数字 53 的二进制为110101，从右往左数的第 32 位为 0，表示该数为正数
 *         逻辑右移 1 位，左边补 0
 *         算数右移时保持符号位补变，除符号位之外的右移 1 位并补符号位
 *         Java 和 Python 的逻辑右移都是 >>>，算数右移都是 >>
 *         C/C++ 中逻辑右移和算数右移都是 >>，编译器根据运算数的类型决定是逻辑右移还是算数右移，如果运算数类型是unsigned，则采用逻辑右移，如果是signed，则采用算数右移
 *     </pre>
 * </pre>
 * <pre>
 *     或：参与操作的位中只要有一个位是 1，那么最终结果就是 1
 *     110101 | 100011 = 110111
 * </pre>
 * <pre>
 *     与：参与操作的位中必须全都是 1，那么最终结果才是 1，否则是 0
 *     110101 & 100011 = 100001
 * </pre>
 * <pre>
 *     异或：如果参与操作的位相同，最终结果是 0，否则是 1
 *     110101 ^ 100011 = 010110
 * </pre>
 *
 * @author chris
 * @since 2023-09-20 25:21
 */
public class BinaryTest {

    public static void main(String[] args) {
        System.out.println("二进制测试 start");

        System.out.println("二进制-十进制转换");
        int a = 53;
        String b = "110101";
        // 获取十进制数53的二进制数
        System.out.printf("数字%d的二进制是%s%n", a, decimalToBinary(a));
        // 获取二进制数110101的十进制数
        System.out.printf("数字%s的十进制是%d%n", b, binaryToDecimal(b));

        System.out.println("二进制左移");
        int num = 53;
        int m = 1;
        // 测试向左移位
        System.out.printf("数字%d的二进制向左移%d位是%d%n", num, m, leftShift(num, m));
        // 测试向右移位
        System.out.printf("数字%d的二进制向右移%d位是%d%n", num, m, rightShift(num, m));

        System.out.println("二进制右移");
        m = 3;
        // 测试向左移位
        System.out.printf("数字%d的二进制向左移%d位是%d%n", num, m, leftShift(num, m));
        // 测试向右移位;
        System.out.printf("数字%d的二进制向右移%d位是%d%n", num, m, rightShift(num, m));

        System.out.println("二进制按位运算");
        int num1 = 53;
        int num2 = 35;

        // 获取十进制数53和35的按位“或”
        System.out.printf("数字%d(%s)和数字%d(%s)的按位‘或’结果是%d(%s)%n", num1, decimalToBinary(num1), num2, decimalToBinary(num2), or(num1, num2), decimalToBinary(or(num1, num2)));

        // 获取十进制数53和35的按位“与”
        System.out.printf("数字%d(%s)和数字%d(%s)的按位‘与’结果是%d(%s)%n", num1, decimalToBinary(num1), num2, decimalToBinary(num2), and(num1, num2), decimalToBinary(and(num1, num2)));

        // 获取十进制数53和35的按位“异或”
        System.out.printf("数字%d(%s)和数字%d(%s)的按位‘异或’结果是%d(%s)%n", num1, decimalToBinary(num1), a, decimalToBinary(num1), xor(num1, num1), decimalToBinary(xor(num1, num1)));

        System.out.println("二进制测试 end");
    }


    /**
     * 将十进制转换成二进制
     *
     * @param decimalSource 十进制
     * @return 二进制
     */
    public static String decimalToBinary(int decimalSource) {
        BigInteger i = new BigInteger(String.valueOf(decimalSource));
        return i.toString(2);
    }

    /**
     * 将二进制转换成十进制
     *
     * @param binarySource 二进制
     * @return 十进制
     */
    public static int binaryToDecimal(String binarySource) {
        BigInteger i = new BigInteger(binarySource, 2);
        return Integer.parseInt(i.toString());
    }

    /**
     * 向左移位
     *
     * @param num 待移位的十进制数
     * @param m   向左移位的位数
     * @return 移位结果
     */
    public static int leftShift(int num, int m) {
        return num << m;
    }

    /**
     * 向右移位
     *
     * @param num 待移位的十进制数
     * @param m   向右移位的位数
     * @return 移位结果
     */
    public static int rightShift(int num, int m) {
        return num >>> m;
    }

    /**
     * 二进制按位“或”操作
     *
     * @param num1 第一个数字
     * @param num2 第二个数字
     * @return 二进制按位“或”的结果
     */
    public static int or(int num1, int num2) {
        return num1 | num2;
    }

    /**
     * 二进制按位“与”操作
     *
     * @param num1 第一个数字
     * @param num2 第二个数字
     * @return 二进制按位“与”的结果
     */
    public static int and(int num1, int num2) {
        return num1 & num2;
    }

    /**
     * 二进制按位“异或”操作
     *
     * @param num1 第一个数字
     * @param num2 第二个数字
     * @return 二进制按位“异或”的结果
     */
    public static int xor(int num1, int num2) {
        return num1 ^ num2;
    }

}
