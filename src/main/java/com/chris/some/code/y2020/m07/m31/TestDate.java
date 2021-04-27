package com.chris.some.code.y2020.m07.m31;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        String str = "2020-07-13";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date parse = dateFormat.parse(str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        calendar.add(Calendar.DAY_OF_YEAR, -180);
        System.out.println(dateFormat.format(calendar.getTime()));
    }
}
