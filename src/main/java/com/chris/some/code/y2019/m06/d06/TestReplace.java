package com.chris.some.code.y2019.m06.d06;

import com.chris.some.code.y2019.m06.d03.stream.Data;

public class TestReplace {
    public static void main(String[] args) {
        String m = "车主：V,于W,在X,发生Y,录入时间：Z";
        String x = m.replace("V", Data.getData().get(0).getName()).replace("W", Data.getData().get(0).getSex());
        System.out.println(m);
        System.out.println(x);
    }
}
