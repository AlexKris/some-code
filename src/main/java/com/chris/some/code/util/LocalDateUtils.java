package com.chris.some.code.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java LocalDate util
 *
 * @author grt
 * @version 1.0
 * @since 2022-12-07 14:50:18
 */
public class LocalDateUtils {

    public static LocalDate parseDate(String date, String paramFormatStr) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(paramFormatStr));
    }

    public static YearMonth parseYearMonth(String date, String paramFormatStr) {
        return YearMonth.parse(date, DateTimeFormatter.ofPattern(paramFormatStr));
    }

    public static LocalDateTime parseDateTime(String date, String paramFormatStr) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(paramFormatStr));
    }

    public static String getDateFormat(String formatStr) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(formatStr));
    }

    public static String getDateFormat(Date date, String formatStr) {
        ZoneId zoneId = ZoneId.systemDefault();
        return date.toInstant().atZone(zoneId).toLocalDateTime().format(DateTimeFormatter.ofPattern(formatStr));
    }

    public static String getDateFormat(String date, String paramFormatStr, String formatStr) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(paramFormatStr)).format(DateTimeFormatter.ofPattern(formatStr));
    }

    public static String getYearMonth(String date, String paramFormatStr, String formatStr) {
        return YearMonth.parse(date, DateTimeFormatter.ofPattern(paramFormatStr)).format(DateTimeFormatter.ofPattern(formatStr));
    }

    public static String getDateTimeFormat(String date, String paramFormatStr, String formatStr) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(paramFormatStr)).format(DateTimeFormatter.ofPattern(formatStr));
    }

    public static String getTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public static List<String> getDateByDay(String startDate, String endDate, String paramFormatStr, String formatStr) {
        LocalDate startLocalDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern(paramFormatStr));
        LocalDate endLocalDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern(paramFormatStr));
        List<LocalDate> localDateList = Stream.iterate(startLocalDate, localDate -> localDate.plusDays(1)).limit(ChronoUnit.DAYS.between(startLocalDate, endLocalDate)).collect(Collectors.toList());
        localDateList.add(endLocalDate);
        return localDateList.stream().map(localDate -> localDate.format(DateTimeFormatter.ofPattern(formatStr))).collect(Collectors.toList());
    }

    public static boolean isEndOfMonth(String date, String paramFormatStr) {
        LocalDate inDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(paramFormatStr));
        LocalDate lastDate = inDate.with(TemporalAdjusters.lastDayOfMonth());
        return inDate.compareTo(lastDate) == 0;
    }

}
