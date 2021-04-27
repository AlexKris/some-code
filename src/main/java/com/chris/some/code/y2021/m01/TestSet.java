package com.chris.some.code.y2021.m01;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        String json = "{\n" +
                "    \"status\": \"1\",\n" +
                "    \"brand_list\": [\n" +
                "        {\n" +
                "            \"brand_id\": \"1\",\n" +
                "            \"brand_name\": \"奥迪\",\n" +
                "            \"initial\": \"A\",\n" +
                "            \"update_time\": \"2016-01-20 23:23:12\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"brand_id\": \"2\",\n" +
                "            \"brand_name\": \"阿斯顿·马丁\",\n" +
                "            \"initial\": \"A\",\n" +
                "            \"update_time\": \"2016-01-20 23:23:12\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(json);
        System.out.println("jsonObject = " + jsonObject);
        JSONArray brandList = jsonObject.getJSONArray("brand_list");
        System.out.println("brandList = " + brandList);
        Set<String> brandGroup = new HashSet<>();
        for (int i = 0; i < brandList.size(); i++) {
            JSONObject jsonObject1 = brandList.getJSONObject(i);
            System.out.println("jsonObject1 = " + jsonObject1);
            boolean initial = brandGroup.add(jsonObject1.getString("initial"));
            System.out.println("initial = " + initial);
            System.out.println("brandGroup = " + brandGroup);
        }
        System.out.println("brandGroup = " + brandGroup);
    }
}
