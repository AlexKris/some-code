package com.chris.some.code.study.onjava.enums.values;

/**
 * 枚举向上转型，会丢失 values() 方法
 *
 * @author grt
 * @since 2022-07-22 15:19:25
 */
public class UpCaseEnum {

    public static void main(String[] args) {
        Search[] values = Search.values();
        Enum<Search> hither = Search.HITHER;
//        hither.values();
        for (Enum enumConstant : hither.getClass().getEnumConstants()) {
            System.out.println("enumConstant = " + enumConstant);
        }
    }
}
