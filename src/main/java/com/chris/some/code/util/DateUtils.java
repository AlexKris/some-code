package com.chris.some.code.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 *
 * @author 高瑞廷
 * @date 2019-08-02
 */
public class DateUtils {
    /**
     * 日期时间格式:2019-08-02 15:43:10
     */
    private static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期时间格式:20190802154310
     */
    private static final String DATETIME_SPECIAL_FORMAT = "yyyyMMddHHmmss";
    /**
     * 日期格式:2019-08-02
     */
    private static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";
    /**
     * 日期格式:20190802
     */
    private static final String DATE_DEFAULT_FORMAT_ONE = "yyyyMMdd";
    /**
     * 年月格式:2019-08
     */
    private static final String DATETIME_DEFAULT_MONTH_FORMAT = "yyyy-MM";
    /**
     * 年月格式:201908
     */
    private static final String DATE_DEFAULT_MONTH_FORMAT = "yyyyMM";
    /**
     * 时间格式:15:43:10
     */
    private static final String TIME_DEFAULT_FORMAT = "HH:mm:ss";

    /**
     * 日期时间格式:2019-08-02 15:43:10
     */
    private static DateFormat dateTimeFormat = null;
    /**
     * 日期时间格式:20190802154310
     */
    private static DateFormat dateTimeSpecialFormat = null;
    /**
     * 日期格式化:2019-08-02
     */
    private static DateFormat dateFormat = null;
    /**
     * 日期格式化:20190802
     */
    private static DateFormat dateDefaultFormat = null;
    /**
     * 日期格式化:201908
     */
    private static DateFormat dtDefaultFormat = null;
    /**
     * 时间格式:15:43:10
     */
    private static DateFormat timeFormat = null;
    private static Calendar gregorianCalendar = null;

    static {
        dateTimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
        dateTimeSpecialFormat = new SimpleDateFormat(DATETIME_SPECIAL_FORMAT);
        dateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
        dateDefaultFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT_ONE);
        dtDefaultFormat = new SimpleDateFormat(DATE_DEFAULT_MONTH_FORMAT);
        timeFormat = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
        gregorianCalendar = new GregorianCalendar();
    }

    /**
     * 每一个线程
     */
    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 日期格式化yyyy-MM-dd
     *
     * @param format
     * @param date
     * @return
     */
    public static Date formatDate(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parse(String dateTime, String format) {
        if ("".equals(dateTime)) {
            return null;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            try {
                return dateFormat.parse(dateTime);
            } catch (ParseException e) {
                throw new RuntimeException("format date error!", e);
            }
        }
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /**
     * 日期格式化 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String getDateFormat(Date date) {
        return dateFormat.format(date);
    }

    /**
     * 日期格式化 yyyyMM
     *
     * @param date
     * @return
     */
    public static String getYearMonthStr(Date date) {
        return dtDefaultFormat.format(date);
    }

    /**
     * 获取当前月往前12个月的年月
     */
    public static String[] getYearMonthList() {
        String[] dateList = new String[]{
                getYearMonthStr(getLastMonthDataOfCurrent(1)),
                getYearMonthStr(getLastMonthDataOfCurrent(2)),
                getYearMonthStr(getLastMonthDataOfCurrent(3)),
                getYearMonthStr(getLastMonthDataOfCurrent(4)),
                getYearMonthStr(getLastMonthDataOfCurrent(5)),
                getYearMonthStr(getLastMonthDataOfCurrent(6)),
                getYearMonthStr(getLastMonthDataOfCurrent(7)),
                getYearMonthStr(getLastMonthDataOfCurrent(8)),
                getYearMonthStr(getLastMonthDataOfCurrent(9)),
                getYearMonthStr(getLastMonthDataOfCurrent(10)),
                getYearMonthStr(getLastMonthDataOfCurrent(11)),
                getYearMonthStr(getLastMonthDataOfCurrent(12)),
        };

        return dateList;
    }

    /**
     * 日期格式化 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getDateTimeFormat(Date date) {
        return dateTimeFormat.format(date);
    }

    /**
     * 时间格式化 HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getTimeFormat(Date date) {
        return timeFormat.format(date);
    }

    /**
     * 日期格式化
     *
     * @param date
     * @param formatStr 格式类型
     * @return
     */
    public static String getDateFormat(Date date, String formatStr) {
        if (!"".equals(formatStr)) {
            return new SimpleDateFormat(formatStr).format(date);
        }
        return null;
    }

    /**
     * 日期格式化
     *
     * @param date
     * @return
     */
    public static Date getDateFormat(String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间格式化
     *
     * @param date
     * @return
     */
    public static Date getDateTimeFormat(String date) {
        try {
            return dateTimeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前日期 yyyy-MM-dd
     *
     * @return
     */
    public static Date getNowDate() {
        return getDateFormat(dateFormat.format(new Date()));
    }


    /**
     * 日期格式化 yyyyMMdd
     *
     * @param date
     * @return
     */
    public static String getNowDateFormat(Date date) {
        return dateDefaultFormat.format(date);
    }

    /**
     * 获取当前日期星期一日期
     *
     * @return
     */
    public static Date getFirstDayOfWeek() {
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(new Date());
        // Monday
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek());
        return gregorianCalendar.getTime();
    }

    /**
     * 获取当前日期星期日日期
     *
     * @return
     */
    public static Date getLastDayOfWeek() {
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(new Date());
        // Monday
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek() + 6);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取日期星期一日期
     *
     * @param date 指定日期
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(date);
        // Monday
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek());
        return gregorianCalendar.getTime();
    }

    /**
     * 获取日期星期一日期
     *
     * @param date 指定日期
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(date);
        // Monday
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek() + 6);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取当前月的第一天
     *
     * @return
     */
    public static Date getFirstDayOfMonth() {
        gregorianCalendar.setTime(new Date());
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取当前月的最后一天
     *
     * @return
     */
    public static Date getLastDayOfMonth() {
        gregorianCalendar.setTime(new Date());
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        gregorianCalendar.add(Calendar.MONTH, 1);
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取指定月的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取指定月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        gregorianCalendar.add(Calendar.MONTH, 1);
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取日期前一天
     *
     * @param date
     * @return
     */
    public static Date getDayBefore(Date date) {
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set(Calendar.DATE, day - 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取日期后一天
     *
     * @param date
     * @return
     */
    public static Date getDayAfter(Date date) {
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set(Calendar.DATE, day + 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取当前年
     *
     * @return
     */
    public static int getNowYear() {
        Calendar d = Calendar.getInstance();
        return d.get(Calendar.YEAR);
    }

    /**
     * 获取当前月份
     *
     * @return
     */
    public static int getNowMonth() {
        Calendar d = Calendar.getInstance();
        return d.get(Calendar.MONTH) + 1;
    }

    public static int getNowDay() {
        Calendar d = Calendar.getInstance();
        return d.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当月天数
     *
     * @return
     */
    public static int getNowMonthDay() {
        Calendar d = Calendar.getInstance();
        return d.getActualMaximum(Calendar.DATE);
    }

    /**
     * 获取时间段的每一天
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static List<Date> getEveryDay(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return null;
        }
        // 格式化日期(yy-MM-dd)
        startDate = getDateFormat(getDateFormat(startDate));
        endDate = getDateFormat(getDateFormat(endDate));
        List<Date> dates = new ArrayList<Date>();
        gregorianCalendar.setTime(startDate);
        dates.add(gregorianCalendar.getTime());
        while (gregorianCalendar.getTime().compareTo(endDate) < 0) {
            // 加1天
            gregorianCalendar.add(Calendar.DAY_OF_MONTH, 1);
            dates.add(gregorianCalendar.getTime());
        }
        return dates;
    }

    /**
     * 传入具体日期 ，返回具体日期增加N个月
     *
     * @param date 日期 2017-04
     * @return 2017-05
     */
    public static String getNextMonth(Date date, int addMonth, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, addMonth);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    /**
     * 获取提前多少个月
     *
     * @param monty
     * @return
     */
    public static Date getFirstMonth(int monty) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -monty);
        return c.getTime();
    }

    /**
     * 格式化前几天
     *
     * @param now        当前需转换的日期
     * @param num        距离之前的天数
     * @param dateFormat 格式
     * @return 字符串类型的格式化的前几天
     */
    public static String getBeforeData(Date now, int num, String dateFormat) {
        Date bDate = new Date();
        //得到日历
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        //设置为前一天
        calendar.add(Calendar.DAY_OF_MONTH, num);
        //得到前一天的时间
        bDate = calendar.getTime();
        //设置时间格式
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        //格式化前一天
        String defaultStartDate = sdf.format(bDate);
        return defaultStartDate;
    }

    /**
     * 格式化前1天
     *
     * @param dateFormat 格式
     * @return 字符串类型的格式化的前几天
     */
    public static String getBeforeOneDate(String dateFormat) {
        Date bDate = new Date();
        //得到日历
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(bDate);
        //设置为前一天
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        //得到前一天的时间
        bDate = calendar.getTime();
        //设置时间格式
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        //格式化前一天
        String defaultStartDate = sdf.format(bDate);
        return defaultStartDate;
    }


    /**
     * 获取两个月份之差
     *
     * @param startMonth
     * @param endMonth
     * @return
     */
    public static Integer getMonthDValue(String startMonth, String endMonth) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_DEFAULT_MONTH_FORMAT);
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        try {
            bef.setTime(sdf.parse(startMonth));
            aft.setTime(sdf.parse(endMonth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;

        return Math.abs(month + result);
    }

    /**
     * 将字符串（类型Pattren）转换为时间戳
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Long DateToTime(String date, String pattern) {
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(new SimpleDateFormat(pattern).parse(date));
        } catch (ParseException e) {
            //若出现异常，则返回当前时间戳
            return System.currentTimeMillis();
        }
        return c.getTimeInMillis();
    }

    /**
     * 将时间字符串yyyy-MM-dd转为时间戳
     *
     * @param date
     * @return
     */
    public static Long convertToTime1(String date) {
        return DateToTime(date, "yyyy-MM-dd");
    }

    /**
     * 将时间字符串yyyy-MM-dd HH:mm:ss转为时间戳
     *
     * @param date
     * @return
     */
    public static Long convertToTime2(String date) {
        return DateToTime(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 两个日期相差天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDaysByLong(long date1, long date2) {
        return (int) ((date1 - date2) / (24 * 60 * 60 * 1000));
    }

    /**
     * 两个日期相差小时数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareHoursByLong(long date1, long date2) {
        return (int) ((date1 - date2) / (60 * 60 * 1000));
    }

    /**
     * 两个日期相差分钟数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareMinutesByLong(long date1, long date2) {
        return (int) ((date1 - date2) / (60 * 1000));
    }

    /**
     * 计算两日期相隔几天几小时
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public static String computingTime(String startDate, String endDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now;
        Date date;
        try {
            now = df.parse(endDate);
            date = df.parse(startDate);
            long l = now.getTime() - date.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            return "" + day + "天" + hour + "小时" + min + "分钟";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据开始时间和结束时间计算之间的月份，如果都不传则从当前日期前推一年
     *
     * @param startDate 开始时间字符串
     * @param endDate   结束时间字符串
     * @return
     */
    public static Map<String, Map<String, String>> computeYearMonthMap(String startDate, String endDate) {
        // 如果不选择日期，则默认当前时间前推一年
        if ((startDate == null || startDate.isEmpty()) || (endDate == null || endDate.isEmpty())) {
            Calendar calendar = Calendar.getInstance();
            endDate = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH);
            calendar.add(Calendar.YEAR, -1);
            startDate = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1);
        }
        String[] startArr = startDate.split("-");
        String[] endArr = endDate.split("-");
        //起始年份
        Integer startYear = Integer.valueOf(startArr[0]);
        //结束年份
        Integer endYear = Integer.valueOf(endArr[0]);
        //其实月份
        Integer startMonth = Integer.valueOf(startArr[1]);
        //结束月份
        Integer endMonth = Integer.valueOf(endArr[1]);
        TreeMap<String, Map<String, String>> dateMap = new TreeMap<>();
        //选择年份是同一年
        if (startYear.equals(endYear)) {
            for (int i = startMonth; i <= endMonth; i++) {
                Map<String, String> valueMap = new HashMap<>();
                valueMap.put("year", startYear + "");
                valueMap.put("month", i + "");
                dateMap.put(startYear + "" + "年" + String.format("%02d", i) + "月", valueMap);
            }
        } else {
            //选择年份是不同年份
            for (; startMonth <= 12; ) {
                Map<String, String> valueMap = new HashMap<>();
                valueMap.put("year", startArr[0]);
                valueMap.put("month", String.valueOf(startMonth));
                dateMap.put(startArr[0] + "年" + String.format("%02d", startMonth) + "月", valueMap);
                startMonth++;
            }
            for (int i = 1; i <= endMonth; i++) {
                Map<String, String> valueMap = new HashMap<>();
                valueMap.put("year", endArr[0]);
                valueMap.put("month", String.valueOf(i));
                dateMap.put(endArr[0] + "年" + String.format("%02d", i) + "月", valueMap);
            }
        }
        return dateMap;
    }

    /**
     * 获取当前日期前N个月的日期
     *
     * @param monthNum
     * @return
     */
    public static Date getLastMonthDataOfCurrent(int monthNum) {
        Calendar currentCal = Calendar.getInstance();
        currentCal.add(Calendar.MONTH, -monthNum);
        return currentCal.getTime();
    }

    /**
     * 获取N周之前的日期
     *
     * @param weekNum
     * @return
     */
    public static Date getLastWeekDateOfCurrent(int weekNum) {
        Calendar currentCal = Calendar.getInstance();
        currentCal.add(Calendar.WEEK_OF_MONTH, -weekNum);
        int day = currentCal.get(Calendar.DAY_OF_MONTH);
        currentCal.set(Calendar.DAY_OF_MONTH, day + 1);
        return currentCal.getTime();
    }

    /**
     * 获取当前日期时间格式化
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String nowDateTime() {
        return getDateTimeFormat(new Date());
    }

    /**
     * 获取当前日期格式化
     *
     * @return yyyy-MM-dd
     */
    public static String nowDate() {
        return getDateFormat(new Date());
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss转换为yyyyMMddHHmmss
     *
     * @param dateTime
     * @return
     */
    public static String formatDateDefaultToSpecial(String dateTime) {
        if (NullUtils.isNullOrEmpty(dateTime)) {
            return null;
        }
        try {
            return dateTimeSpecialFormat.format(dateTimeFormat.parse(dateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss转换为yyyyMMdd
     *
     * @param dateTime
     * @return
     */
    public static String formatDateDefaultToSpecial2(String dateTime) {
        if (NullUtils.isNullOrEmpty(dateTime)) {
            return null;
        }
        try {
            return dateDefaultFormat.format(dateTimeFormat.parse(dateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss转换为yyyy-MM-dd
     *
     * @param dateTime
     * @return
     */
    public static String formatDateDefaultToSpecial3(String dateTime) {
        if (NullUtils.isNullOrEmpty(dateTime)) {
            return null;
        }
        try {
            return dateFormat.format(dateTimeFormat.parse(dateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将yyyyMMddHHmmss转换为yyyy-MM-dd HH:mm:ss
     *
     * @param dateTime
     * @return
     */
    public static String formatDateDefaultToSpecial4(String dateTime) {
        if (NullUtils.isNullOrEmpty(dateTime)) {
            return null;
        }
        try {
            return dateTimeFormat.format(dateTimeSpecialFormat.parse(dateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
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

    public static String getDaysBetweenNowByDay(String nowDate, int day) {
        try {
            Date date = dateTimeFormat.parse(nowDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, day);
            Date time = calendar.getTime();
            return dateDefaultFormat.format(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getBeforeDay(int day) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        Date time = calendar.getTime();
        return dateDefaultFormat.format(time);
    }

    public static String getBeforeDay2(int day) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        Date time = calendar.getTime();
        return dateFormat.format(time);
    }
}
