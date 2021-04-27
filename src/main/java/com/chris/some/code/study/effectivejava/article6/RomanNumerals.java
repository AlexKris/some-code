package com.chris.some.code.study.effectivejava.article6;

import java.util.regex.Pattern;

// Reusing expensive object for improved performance
public class RomanNumerals {
    // 匹配罗马数字
    private static final Pattern ROMAN =
            Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    // 不适合在注重性能的情况下重复使用
    static boolean isRomanNumeralOld(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
