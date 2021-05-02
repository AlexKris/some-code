package com.chris.some.code.y2021.m03.d01;

import com.chris.some.code.util.DateUtils;
import com.chris.some.code.util.JacksonUtils;
import com.chris.some.code.util.NullUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FiveYearStateTest {

    public static void main(String[] args) throws ParseException {
        String reportTime = "2021.02.20 14:23:45";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        Date date = format.parse("2021-02");
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -60);
        String startCalMonth = format.format(calendar.getTime());
        System.out.println("startCalMonth = " + startCalMonth);
        String endCalMonth = "2021-02";
        Map<String, Object> map = new HashMap<>();
        map.put("startCalMonth", startCalMonth);
        map.put("endCalMonth", endCalMonth);

        String json1FromMonth = "2021-1";
        String json1 = "[{\"pd01er03\":\"2021-1\",\"pd01ed01\":\"*\",\"pd01ej01\":\"￥\",\"pd01ai01\":\"账户1\"}]\t";
        String json1ToMonth = "2021-1";
        String state1 = solveState(json1, map, json1FromMonth, json1ToMonth);
        System.out.println("state1 = " + state1);
        int result1 = solveRecentIndex(state1, 0, 24 * 5, 1, json1ToMonth);
        System.out.println("result1 = " + result1);

        String json2FromMonth = "2021-2";
        String json2 = "[{\"pd01er03\":\"2021-2\",\"pd01ed01\":\"*\",\"pd01ej01\":\"￥\",\"pd01ai01\":\"账户2\"}]\t";
        String json2ToMonth = "2021-2";
        String state2 = solveState(json2, map, json2FromMonth, json2ToMonth);
        System.out.println("state2 = " + state2);
        int result2 = solveRecentIndex(state2, 0, 24 * 5, 1, json2ToMonth);
        System.out.println("result2 = " + result2);

    }

    private static String solveState(String json, Map<String, Object> map, String fromMonth, String toMonth) {
        //前面日期19.3 后面日期19.6 返回结果正数
        int num1 = getMonthDValue(fromMonth, map.get("startCalMonth").toString());
        int num2 = getMonthDValue(toMonth, map.get("endCalMonth").toString());
        StringBuilder before = new StringBuilder();
        StringBuilder after = new StringBuilder();
        if (num1 < 0) {//60月在fromMonth之前
            for (int i = 0; i < Math.abs(num1); i++) {
                before.append("/");
            }
        }
        if (num2 > 0) {
            if (num2 == Math.abs(num1)) {
                for (int i = 0; i < num2 - 2; i++) {
                    after.append("/");
                }
            } else {
                for (int i = 0; i < num2 - 1; i++) {
                    after.append("/");
                }
            }

        }

        StringBuilder str = new StringBuilder();
        List<Map<String, String>> maps = JacksonUtils.jsonToObject(json, ArrayList.class);
        Map<Integer, Object> mapIndex = new HashMap<>();
        for (Map<String, String> stringStringMap : maps) {
            String month = stringStringMap.get("pd01er03");
            int index = DealDate(fromMonth, month);
            mapIndex.put(index, stringStringMap.get("pd01ed01"));
        }
        for (int i = 0; i < maps.size(); i++) {
            str.append(mapIndex.get(i));
        }
        str = new StringBuilder(before.toString() + str + after);
        return str.toString();
    }

    public static int getMonthDValue(String startMonth, String endMonth) {
        if (NullUtils.isNullOrEmpty(startMonth)) {
            return -1;
        }
        boolean format = true;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM");
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        try {
            bef.setTime(sdf.parse(startMonth));
            aft.setTime(sdf.parse(endMonth));
        } catch (ParseException e) {
            e.printStackTrace();
            format = false;
        }
        if (!format) {
            try {
                bef.setTime(sdf2.parse(startMonth));
                aft.setTime(sdf.parse(endMonth));
            } catch (ParseException e) {
                e.printStackTrace();
                return -1;
            }
        }
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;

        return month + result;
    }

    private static int DealDate(String fromMonth, String month) {
        if (fromMonth.length() == 6) {
            fromMonth = fromMonth.substring(0, 5) + "0" + fromMonth.charAt(5);
        }
        if (month.length() == 6) {
            month = month.substring(0, 5) + "0" + month.charAt(5);
        }
        //计算时间差值
        return DateUtils.getMonthDValue(fromMonth, month);
    }

    private static int solveRecentIndex(String state, int startMonth, int endMonth, int index, String toMonth) {
        //判断0记录是否大于month 如果大于截取 如果小于 全取
        if (startMonth == 0) {
            if (endMonth >= state.length()) {
                state = state;
            } else {
                state = state.substring(state.length() - endMonth);
            }
        } else {
            if (startMonth >= state.length()) {
                state = null;
            } else if (startMonth < state.length() && state.length() <= endMonth) {
                state = state.substring(0, state.length() - startMonth);
            } else if (startMonth < state.length() && state.length() > endMonth) {
                state = state.substring(state.length() - endMonth, state.length() - startMonth);
            } else {
                state = null;
            }
        }

        if (NullUtils.isNullOrEmpty(toMonth)) {
            return 0;
        }

        int count = 0;
        StringBuilder sb = new StringBuilder(state);
        String str = sb.reverse().toString();
        if (!NullUtils.isNullOrEmpty(str)) {
            char[] chars = str.toCharArray();
            for (char a : chars) {
                if (a == '0' + index) {
                    break;
                }
                count++;
            }
        } else {
            return 0;
        }

        if (count == str.toCharArray().length) {
            return 0;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM", Locale.ENGLISH);
            DateFormat df = new SimpleDateFormat("yyyy-MM");
            Date parse = df.parse(toMonth);
            Calendar c = Calendar.getInstance();
            c.setTime(parse);
            c.add(Calendar.MONTH, (-count));
            String format = sdf.format(c.getTime());
            return Integer.parseInt(format);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
