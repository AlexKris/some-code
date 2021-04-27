package com.chris.some.code.y2020.m09.d02;

import java.util.HashMap;
import java.util.Map;

public class TestOCR {

    /**
     * 字符权重表
     */
    private static final Map<Character, Integer> CHAR_WEIGHTS = new HashMap<>();
    /**
     * 位置权重表
     */
    private static final int[] POS_WEIGHTS = new int[]{8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2};

    static {
        for (int i = 0; i < 10; i++) {
            CHAR_WEIGHTS.put(String.valueOf(i).charAt(0), i);
        }
        CHAR_WEIGHTS.put('A', 1);
        CHAR_WEIGHTS.put('B', 2);
        CHAR_WEIGHTS.put('C', 3);
        CHAR_WEIGHTS.put('D', 4);
        CHAR_WEIGHTS.put('E', 5);
        CHAR_WEIGHTS.put('F', 6);
        CHAR_WEIGHTS.put('G', 7);
        CHAR_WEIGHTS.put('H', 8);
        CHAR_WEIGHTS.put('J', 1);
        CHAR_WEIGHTS.put('K', 2);
        CHAR_WEIGHTS.put('L', 3);
        CHAR_WEIGHTS.put('M', 4);
        CHAR_WEIGHTS.put('N', 5);
        CHAR_WEIGHTS.put('P', 7);
        CHAR_WEIGHTS.put('R', 9);
        CHAR_WEIGHTS.put('S', 2);
        CHAR_WEIGHTS.put('T', 3);
        CHAR_WEIGHTS.put('U', 4);
        CHAR_WEIGHTS.put('V', 5);
        CHAR_WEIGHTS.put('W', 6);
        CHAR_WEIGHTS.put('X', 7);
        CHAR_WEIGHTS.put('Y', 8);
        CHAR_WEIGHTS.put('Z', 9);
    }

    public static void main(String[] args) {
//        System.out.println(getCheck("LVAV2PVBOLE616161"));
//        System.out.println(testVin("LSFAM11A7LA 059009 货单 车架号码"));
//        System.out.println(testVin("购 车架号码 LFP56APC7K1D 23124 一货 11633"));
//        System.out.println(testVin("车架号码 LSFGM21HXLD 302260"));
        System.out.println(testInvoiceCode("人 22566617 发票号码"));
//        System.out.println(testDate("开票日期2020-08-07 031261**-4/-0*>"));
//        System.out.println(testDate("国家税务忌 局 回 发 福建示示局 联 开票日期 2020-08-08"));
//        System.out.println(testDate("L0-80-OZ07日尝 v47CrTI"));
        String regex = "[\\u4E00-\\u9FA5]";
//        System.out.println(testDate("保险期间： 自 2020 年 8 月 8 日"));
        System.out.println(testPrice("不含税价 小写￥ ￥92920.35"));
//        System.out.println(testUse("使用性质 非营业个人 车"));
        System.out.println(testUse("人 30.使用性 质 非营运 32.车辆出厂日期 34.发证 2011-03-08 珊加啡装"));
    }

    private static String testVin(String content) {
        String[][] iterm = {
                {"LSFAM11A7LA 059009 货单 车架号码", "LSFAM11A7LA059009"},
                {"购 车架号码 LFP56APC7K1D 23124 一货 11633", "LFP56APC7K1D23124"},
                {"车架号码 LSFGM21HXLD 302260", "LSFGM21HXLD302260"},
                {"车架号码 LGXC85DE2L 1128576", "LGXC85DF2L1128576"},
                {"购 车架号码 LVBV4JBBOLY 157744 货", "LVBV4JBB1LY157744"},
                {"车架号码 LNBSCUAH5LR 163333", "LNBSCUAH5LR163333"},
                {"车架号码 LFNA8LBAOLAX 41128", "LFNA8LBA4LAX41128"},
        };
//        for (String[] strings : iterm) {
//            System.out.println("strings:" + strings[0]);
//            String replaceAll = strings[0].replaceAll("[^(a-zA-Z0-9)]", "");
//            String vin = replaceAll.substring(replaceAll.indexOf("L"), replaceAll.indexOf("L") + 17);
//            System.out.println("vin:" + vin);
//            System.out.println("equals:" + strings[1].equals(vin));
//            System.out.println("getCheck:" + getCheck(vin));
//            System.out.println();
//        }
        String regex = "^[A-Z0-9]{6,17}$";
        content = content.replaceAll("[^(a-zA-Z0-9)]", "");
        if (!content.startsWith("L")) {
            content = content.substring(content.indexOf("L"));
        }
        if (content.matches(regex)) {
            if ('O' == content.charAt(8)) {
                content = content.replace("O", "4");
            }
        } else if (18 < content.length()) {
            content = content.substring(0, 17);
        }
        return content.trim();
    }

    private static String testDate(String content) {
        content = content.replaceAll(" ", "");
        String regex1 = "(\\d){4}年(\\d){2}月(\\d){2}日";
        String regex2 = "(\\d){4}年(\\d){1}月(\\d){1}日";
        String regex3 = "(\\d){4}年(\\d){2}月(\\d){1}日";
        String regex4 = "(\\d){4}年(\\d){1}月(\\d){2}日";
        for (int i = 0; i < content.length(); i++) {
            if (i + 9 > content.length()) {
                break;
            }
            String substring = content.substring(i, i + 11);
            if (substring.matches(regex1)) {
                content = substring.replaceAll("[\\u4E00-\\u9FA5]", "");
                break;
            }
            substring = content.substring(i, i + 9);
            if (substring.matches(regex2)) {
                content = substring.replace("年", "0");
                content = content.replace("月", "0");
                content = content.replace("日", "");
                break;
            }
            substring = content.substring(i, i + 10);
            if (substring.matches(regex3)) {
                content = substring.replace("年", "");
                content = content.replace("月", "0");
                content = content.replace("日", "");
                break;
            }
            substring = content.substring(i, i + 10);
            if (substring.matches(regex4)) {
                content = substring.replace("年", "0");
                content = content.replace("月", "");
                content = content.replace("日", "");
                break;
            }
        }
        return content.trim();
    }

    private static String testInvoiceCode(String content) {
        StringBuilder sb = new StringBuilder();
        if (content.contains("发票号码")) {
            content = content.split("发票号码").length == 2 ? content.split("发票号码")[1] : content.split("发票号码")[0];
        }
        for (char c : content.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (8 == sb.length()) {
                    break;
                } else {
                    sb.delete(0, sb.length());
                }
            }
        }
        content = sb.toString();
        return content.trim();
    }

    private static String testPrice(String content) {
        content = content.replace(" ", "");
        if (content.contains("￥")) {

        }
        content.split("￥");
        content = content.substring(content.indexOf("￥") + 1);
        String[] split = content.split("\\.");
        String one = split[0];
        String two = split[1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < two.length(); i++) {
            char ch = two.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                break;
            }
        }
        content = one + "." + sb.toString();
        return content.trim();
    }

    private static String testUse(String content) {
        content = content.replace(" ", "");
        if (content.contains("使用性质")) {
            content = content.split("使用性质").length == 2 ? content.split("使用性质")[1] : content.split("使用性质")[0];
        }
        if (content.contains("运")) {
            content = content.split("运")[0];
        }
        if (!content.contains("非")) {
            content = "营运";
        } else {
            content = "非营运";
        }
        return content.trim();
    }

    private static String testPrice2(String content) {
        content = content.replace(" ", "");
        String[] split = content.split("\\.");
        return content.trim();
    }

    public static String getCheckVin(String vin) {
        int sum = 0;
        for (int i = 0; i < vin.length(); i++) {
            char code = vin.charAt(i);
            Integer cw = CHAR_WEIGHTS.get(code);
            if (null == cw) {
                continue;
            }
            int pw = POS_WEIGHTS[i];
            sum += cw * pw;
        }
        return "";
    }

    public static boolean getCheck(String vin) {
        if (null == vin) {
            return false;
        } else if (vin.trim().length() == 17) {
            vin = vin.toUpperCase();
            int sum = 0;
            int checkSum = 0;
            for (int i = 0; i < vin.length(); i++) {
                char code = vin.charAt(i);
                Integer cw = CHAR_WEIGHTS.get(code);
                if (cw == null) {
                    return false;
                }
                int pw = POS_WEIGHTS[i];
                sum += cw * pw;
                if (i == 8) {
                    // 获取校验位的值
                    if (code == 'X') {
                        checkSum = 10;
                    } else if (code >= '0' && code <= '9') {
                        checkSum = Integer.parseInt(String.valueOf(code));
                    } else {
                        return false;
                    }
                }
            }
            return checkSum == sum % 11;
        }
        return false;
    }

}
