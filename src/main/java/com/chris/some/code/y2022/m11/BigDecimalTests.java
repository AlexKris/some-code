package com.chris.some.code.y2022.m11;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BigDecimalTests {

    public static void main(String[] args) {
        BigDecimal zero = BigDecimal.ZERO;
        System.out.println("zero = " + zero);
        DecimalFormat decimalFormat = new DecimalFormat("##,##0.00");
        System.out.println(decimalFormat.format(zero));
        BigDecimal bigDecimal = zero.setScale(2, RoundingMode.HALF_DOWN);
        System.out.println("bigDecimal = " + bigDecimal.toPlainString());
        BigDecimal bigDecimal1 = new BigDecimal("894832.435");
        System.out.println("bigDecimal1 = " + bigDecimal1.setScale(2, RoundingMode.HALF_DOWN).toPlainString());
    }
}
