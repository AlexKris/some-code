package com.chris.some.code.y2019.m05.d29;

import com.chris.some.code.util.NullUtils;

public class SplitTest {

    public static void main(String[] args) {
        String menuIds1 = "132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,160,161,148,149,150,151,153,154,159;1,2,3,131,152";
        String menuIds2 = "1,2,3,131,152,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,160,161,148,149,150,151,153,154,159;";
        String menuIds3 = ";1,2,3,131,152,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,160,161,148,149,150,151,153,154,159";
        String[] menuId1 = menuIds1.split(";");
        System.out.println("menuId1.length:" + menuId1.length);
        System.out.println("menuId1[0]" + menuId1[0]);
        System.out.println("menuId1[1]" + menuId1[1]);
        String[] menuId2 = menuIds2.split(";");
        System.out.println("menuId2.length:" + menuId2.length);
        System.out.println("menuId2[0]" + menuId2[0]);
        String[] menuId3 = menuIds3.split(";");
        System.out.println("menuId3.length:" + menuId3.length);
        System.out.println("menuId3[0]" + menuId3[0]);
        System.out.println("menuId3[0]是否为空" + NullUtils.isNullOrEmpty(menuId3[0]));
        System.out.println("menuId3[1]" + menuId3[1]);
    }
}
