package com.chris.some.code.y2019.m10.d31;

import com.chris.some.code.util.DateUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class LocalDateTest {

    public static void main(String[] args) {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
        TemporalAccessor parse = dateTimeFormatter.parse("2019.01.01");

        System.out.println(parse);


        System.out.println(LocalDateTime.now().withNano(0).format(dateTimeFormatter));

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));

        System.out.println(DateUtils.getDateTimeFormat(new Date()));
        System.out.println(new Date());
    }
}
