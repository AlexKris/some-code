package com.chris.some.code.study.geektime.interview;

/**
 * 测试 finally
 *
 * @author chris
 */
public class FinallyTest {

    public static void main(String[] args) {
        try {
            // System.exit(0); 正常退出 finally 执行
            // System.exit(1); 非正常退出 finally 不执行
            System.exit(1);
        } finally {
            // finally 中代码不会执行
            System.out.println("Print from finally");
        }
    }
}
