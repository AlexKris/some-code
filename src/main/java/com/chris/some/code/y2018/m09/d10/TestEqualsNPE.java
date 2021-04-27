package com.chris.some.code.y2018.m09.d10;

/**
 * equals
 *
 * @author Alex
 */
public class TestEqualsNPE {
    public static void main(String[] args) {
        String str1 = null;
        String str2 = "";
        System.out.println(str1.equals("1"));//空指针
//        System.out.println(str2.equals(str1));//false
    }
}
