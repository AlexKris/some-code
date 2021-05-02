package com.chris.some.code.y2019.m05.d24;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonArrayTest {

    public static void main(String[] args) {
        JSONArray jsonArray = new JSONArray(10);
        JSONObject jsonObject = new JSONObject(2);
        for (int i = 0; i < 10; i++) {
            jsonObject.put("01", i);
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray);
    }
}
