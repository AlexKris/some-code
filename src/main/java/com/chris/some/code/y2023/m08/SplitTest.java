package com.chris.some.code.y2023.m08;

public class SplitTest {

    public static void main(String[] args) {
        String filename = "FAF_CREDIT_NO2203864";
        String[] filenameSplit = filename.split("_");
        int filenameSplitLen = filenameSplit.length;
        System.out.println("filenameSplitLen = " + filenameSplitLen);
        if (filenameSplitLen > 2) {
            String fileType = filenameSplit[filenameSplitLen - 2];
            if (!"CREDIT".equals(fileType)) {
                System.out.println("wrong");
            }
            System.out.println("right");
        }
    }
}
