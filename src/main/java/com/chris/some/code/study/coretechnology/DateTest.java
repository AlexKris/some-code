package com.chris.some.code.study.coretechnology;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateTest {
    public static void main(String[] args) {
        LocalDate of = LocalDate.of(2000, 1, 1);
        int year = of.getYear();
        int monthValue = of.getMonthValue();
        int dayOfMonth = of.getDayOfMonth();
        System.out.println(year + "," + monthValue + "," + dayOfMonth);
        LocalDate plusDays = of.plusDays(1000);
        int plusDaysYear = plusDays.getYear();
        int plusDaysMonthValue = plusDays.getMonthValue();
        int plusDaysDayOfMonth = plusDays.getDayOfMonth();
        System.out.println(plusDaysYear + "," + plusDaysMonthValue + "," + plusDaysDayOfMonth);

        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        date = date.minusDays(today - 1);
        DayOfWeek weekDay = date.getDayOfWeek();
        int value = weekDay.getValue();
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++)
            System.out.println("    ");
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today)
                System.out.println("*");
            else
                System.out.println(" ");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) System.out.println();
    }
}
