package com.chris.some.code.y2024.m05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        String text = "{短信签名}尊敬的{用户姓名变量}，请点击{链接地址}进行签署";

        String s = text.replaceAll("\\{([^}]*)}", "");
        System.out.println("s = " + s);

        Pattern pattern = Pattern.compile("\\{([^}]*)}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

}
