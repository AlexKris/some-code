package com.chris.some.code.y2022.m11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeTests {

    public static void main(String[] args) {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM")));
        System.out.println(LocalDate.now().toString());
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("format = " + format);

        String yyyyMMdd = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println("yyyyMMdd = " + yyyyMMdd);
        String date = "2022-11-17 14:42:05";
        LocalDateTime parse3 = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("parse3 = " + parse3);

        String yyyyMMddHHmmssSSS = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        System.out.println("yyyyMMddHHmmssSSS = " + yyyyMMddHHmmssSSS);
        LocalDate parse4 = LocalDate.parse("2022-10-30", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("parse4 = " + parse4);
        LocalDate with = parse4.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("with = " + with);
        System.out.println(parse4.compareTo(with));

        String format1 = YearMonth.parse("2022-10-30", DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("yyyy-MM"));
        System.out.println("format1 = " + format1);
    }
}
