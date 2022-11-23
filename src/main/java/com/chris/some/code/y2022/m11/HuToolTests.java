package com.chris.some.code.y2022.m11;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.Objects;

public class HuToolTests {

    public static void main(String[] args) {
        JSONObject entries = JSONUtil.parseObj("{}");
        System.out.println(Objects.isNull(entries.getStr("kjsd")));

        String str = "2022-11";
        DateTime parse = DateUtil.parse(str, "yyyy-MM");
        System.out.println("parse = " + parse);
        System.out.println(DateUtil.beginOfMonth(parse).toString("yyyy-MM-dd"));
        System.out.println(DateUtil.endOfMonth(parse).toString("yyyy-MM-dd"));
        DateTime parse1 = DateUtil.parse("2022-11", "yyyy-MM");
        System.out.println("parse1 = " + parse1);
        int year = parse1.year();
        System.out.println("year = " + year);
        DateTime parse2 = DateUtil.parse("2022-11-13");
        System.out.println("parse2 = " + parse2);
        int year1 = parse2.year();
        System.out.println("year1 = " + year1);
        long current = DateUtil.current();
        System.out.println("current = " + current);
        long l = DateUtil.currentSeconds();
        System.out.println("l = " + l);

        String uuid = UUID.fastUUID().toString(true);
        System.out.println("uuid = " + uuid);
    }
}
