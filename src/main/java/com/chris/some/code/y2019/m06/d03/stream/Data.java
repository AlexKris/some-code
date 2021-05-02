package com.chris.some.code.y2019.m06.d03.stream;

import java.util.Arrays;
import java.util.List;

public class Data {

    private static List<PersonModel> list = null;

    static {
        PersonModel zhang = new PersonModel("zhang san", 19, "男");
        PersonModel li = new PersonModel("li si", 19, "女");
        PersonModel wang = new PersonModel("wang wu", 21, "男");
        PersonModel qian = new PersonModel("qian wu", 21, "女");
        list = Arrays.asList(zhang, li, wang, qian);
    }

    public static List<PersonModel> getData() {
        return list;
    }
}
