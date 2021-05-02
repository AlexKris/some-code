package com.chris.some.code.y2019.m10.d14;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    private static final DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String str = "178425.00";
        BigDecimal bigDecimal = new BigDecimal(str);
        int days = getDaysBetweenNowByMonth("2019-10-18 14:35:35", 2);
        System.out.println(days);
        System.out.println(bigDecimal.multiply(new BigDecimal(0.75)).multiply(new BigDecimal(days)).divide(new BigDecimal(10000), 2, BigDecimal.ROUND_HALF_UP));
    }

    public static int getDaysBetweenNowByMonth(String nowDate, int month) {
        try {
            Date date = dateTimeFormat.parse(nowDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, month);
            Date time = calendar.getTime();
            return compareDaysByLong(time.getTime(), date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int compareDaysByLong(long date1, long date2) {
        return (int) ((date1 - date2) / (24 * 60 * 60 * 1000));
    }
}
