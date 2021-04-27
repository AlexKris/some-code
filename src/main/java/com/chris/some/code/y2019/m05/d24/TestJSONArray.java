package com.chris.some.code.y2019.m05.d24;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestJSONArray {
    public static void main(String[] args) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < 10; i++) {
            jsonObject.put("01", i);
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray);
    }
}
