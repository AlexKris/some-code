package com.chris.some.code.y2019.m11.d07;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {

    private static final String NORMAL_FREEZE = "正常、冻结、止付";

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Optional<String> reduce = stream.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        System.out.println(reduce.get());

        String string = null;
        Optional<String> optionalS = Optional.ofNullable(string);
        System.out.println(optionalS.isPresent());
        System.out.println(optionalS.get().isEmpty());

        String str = "/*NNN****NNNNN123456777N";
        String substring = str.substring(12);
        System.out.println(substring);
        System.out.println(getMaxNum(substring));

        System.out.println(getLongestNum(str));

        System.out.println(NORMAL_FREEZE.contains(null));

        String str2 = "0";
        String[] split = str2.split("\\^\\?");
        System.out.println(split.length);
        System.out.println(split);
    }

    private static int getMaxNum(String state) {
        int maxNum = 0;
        char[] chars = state.toCharArray();
        for (char a : chars) {
            if (Character.isDigit(a)) {
                int numericValue = Character.getNumericValue(a);
                if (maxNum < numericValue) {
                    maxNum = numericValue;
                }
            }
        }
        return maxNum;
    }

    private static int getLongestNum(String state) {
        int overDueTotalIn24 = 0;
        char[] chars = state.toCharArray();
        for (char a : chars) {
            if (Character.isDigit(a)) {
                overDueTotalIn24 += 1;
            }
        }
        return overDueTotalIn24;
    }
}
