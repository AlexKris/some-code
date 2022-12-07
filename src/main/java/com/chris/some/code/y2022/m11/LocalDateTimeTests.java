package com.chris.some.code.y2022.m11;

import com.chris.some.code.util.LocalDateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeTests {

    public static void main(String[] args) {
        System.out.println(LocalDate.now().toString());
        System.out.println(LocalDateUtils.getDateFormat("yyyy-MM"));
        System.out.println(LocalDateUtils.getDateFormat("yyyy-MM-dd HH:mm:ss"));

        String format = LocalDateUtils.getDateFormat("yyyy-MM-dd");
        System.out.println("format = " + format);

        String yyyyMMdd = LocalDateUtils.getDateFormat("yyyyMMdd");
        System.out.println("yyyyMMdd = " + yyyyMMdd);
        String date = "2022-11-17 14:42:05";
        LocalDateTime parse3 = LocalDateUtils.parseDateTime(date, "yyyy-MM-dd HH:mm:ss");
        System.out.println("parse3 = " + parse3);

        String yyyyMMddHHmmssSSS = LocalDateUtils.getDateFormat("yyyyMMddHHmmssSSS");
        System.out.println("yyyyMMddHHmmssSSS = " + yyyyMMddHHmmssSSS);
        LocalDate parse4 = LocalDateUtils.parseDate("2022-10-30", "yyyy-MM-dd");
        System.out.println("parse4 = " + parse4);
        LocalDate with = parse4.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("with = " + with);
        System.out.println(parse4.compareTo(with));

        String format1 = LocalDateUtils.getYearMonth("2022-10-30", "yyyy-MM-dd", "yyyy-MM");
        System.out.println("format1 = " + format1);
        String format2 = LocalDateUtils.getYearMonth("2022-10-30", "yyyy-MM-dd", "yyyy");
        System.out.println("format2 = " + format2);
        int year = LocalDateUtils.parseYearMonth("2022-10-30", "yyyy-MM-dd").getYear();
        System.out.println("year = " + year);

        YearMonth yearMonth = LocalDateUtils.parseYearMonth("2022-11", "yyyy-MM");
        System.out.println("yearMonth = " + yearMonth);
    }
}
