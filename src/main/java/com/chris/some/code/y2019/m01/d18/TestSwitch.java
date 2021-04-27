package com.chris.some.code.y2019.m01.d18;

public class TestSwitch {
    public static void main(String[] args) {
        testSwitch("01");
    }

    /**
     * ex支持类型
     * 1. 基本数据类型：byte, short, char, int
     * 2. 包装数据类型：Byte, Short, Character, Integer
     * 3. 枚举类型：Enum
     * 4. 字符串类型：String（Jdk 7+ 开始支持）
     * <p>
     * 注意:
     * 1. case 里面必须跟 break，不然程序会一个个 case 执行下去，直到最后一个 break 的 case 或者 default 出现。
     * 2. case 条件里面只能是常量或者字面常量。
     * 3. default 语句可有可无，最多只能有一个。
     *
     * @param ex
     */
    private static void testSwitch(String ex) {
        switch (ex) {
            case "01":
                System.out.println("主申请人");
                break;
            case "05":
                System.out.println("主申请人配偶");
                break;
            default:
                System.out.println("主申请人/配偶");
        }
    }
}
