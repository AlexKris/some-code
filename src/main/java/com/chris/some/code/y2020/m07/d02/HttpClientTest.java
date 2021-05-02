package com.chris.some.code.y2020.m07.d02;

import cn.hutool.json.JSONObject;
import com.chris.some.code.util.HttpClientUtils;

public class HttpClientTest {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("param", "123");
        String url = "http://10.10.10.154:8087/user/hello";
        System.out.println(HttpClientUtils.httpPostJson(url, jsonObject.toString()));
    }
}
