package com.chris.some.code.y2020.m04.d23;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class TestHtmlAppend {
    public static void main(String[] args) {
//        String param = "{query:{bool:{must_not:[{match:{APPL_CDE:\"202004171300017984643\"}},{match:{ID_NO:\"230119198610040179\"}}],must:[{match:{REPEAT_VAL:\"18041116666\"}},{match:{REPEAT_TYP:\"05\"}}]}}}";
//        String json = JSON.parseObject(param).toString();
//        System.out.println(json);
//        JSONObject json = new JSONObject();
//        String st = json.getString("st");
//        System.out.println(st);
//        System.out.println(null == st);
//        System.out.println("null".equals(st));
//
//        JSONObject data = json.getJSONObject("data");
//        System.out.println(data);
//        System.out.println(null == data);
//        System.out.println(Objects.isNull(data));
//
//        BigDecimal ahrSeq = json.getBigDecimal("ahrSeq");
//        System.out.println(ahrSeq);
//        System.out.println(null == ahrSeq);
//        System.out.println("null".equals(ahrSeq));
//
//        String str = "[\n" +
//                "    {\n" +
//                "        \"originalFileTypeList\": [\n" +
//                "            \"/身份证明材料/身份证/身份证正面\",\n" +
//                "            \"/身份证明材料/身份证/身份证反面\"\n" +
//                "        ],\n" +
//                "        \"goalFileTypeList\": [\n" +
//                "            \"/身份证明材料/身份证\"\n" +
//                "        ],\n" +
//                "        \"docCde\": \"DOC0201\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"originalFileTypeList\": [\n" +
//                "            \"/征信授权书/征信授权书\"\n" +
//                "        ],\n" +
//                "        \"goalFileTypeList\": [\n" +
//                "            \"/征信查询授权书\"\n" +
//                "        ],\n" +
//                "        \"docCde\": \"DOC1201\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"originalFileTypeList\": [\n" +
//                "            \"/申请授权书/申请授权书\"\n" +
//                "        ],\n" +
//                "        \"goalFileTypeList\": [\n" +
//                "            \"/申请授权书\"\n" +
//                "        ],\n" +
//                "        \"docCde\": \"DOC1501\"\n" +
//                "    }\n" +
//                "]";
//        JSONArray objects = JSON.parseArray(str);
//        System.out.println(objects);

        String s = "[\n" +
                "    {\n" +
                "        \"a200\": \"2010-07\",\n" +
                "        \"a65\": \"CBBM2\",\n" +
                "        \"a66\": \"CAAR1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2010-08\",\n" +
                "        \"a65\": \"CBBM7\",\n" +
                "        \"a66\": \"CAAR2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2010-09\",\n" +
                "        \"a65\": \"CBBM8\",\n" +
                "        \"a66\": \"CAAR2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2010-10\",\n" +
                "        \"a65\": \"CBBM9\",\n" +
                "        \"a66\": \"CAAR3\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2010-11\",\n" +
                "        \"a65\": \"CBBM2\",\n" +
                "        \"a66\": \"CAAR1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2010-12\",\n" +
                "        \"a65\": \"CBBM2\",\n" +
                "        \"a66\": \"CAAR1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2011-01\",\n" +
                "        \"a65\": \"CBBM2\",\n" +
                "        \"a66\": \"CAAR1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2011-02\",\n" +
                "        \"a65\": \"CBBM2\",\n" +
                "        \"a66\": \"CAAR1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2011-03\",\n" +
                "        \"a65\": \"CBBM2\",\n" +
                "        \"a66\": \"CAAR1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2011-04\",\n" +
                "        \"a65\": \"CBBM2\",\n" +
                "        \"a66\": \"CAAR1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2011-05\",\n" +
                "        \"a65\": \"CBBM2\",\n" +
                "        \"a66\": \"CAAR1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2011-06\",\n" +
                "        \"a65\": \"CBBM2\",\n" +
                "        \"a66\": \"CAAR1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2011-07\",\n" +
                "        \"a65\": \"CBBM2\",\n" +
                "        \"a66\": \"CAAR1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"a200\": \"2011-08\",\n" +
                "        \"a65\": \"CZBE8\",\n" +
                "        \"a66\": \"#\"\n" +
                "    }\n" +
                "]";
        //  五年历史数据表现
        JSONObject jsonObject = null;
        Map<String, JSONObject> infos = new HashMap<>();
        List<String> yearList = new ArrayList<>(8);
        String stateDesc = "逾期总额";
        String year = null;
        String date = null;
        for (Object obj : JSONArray.parseArray(s)) {
            jsonObject = JSONObject.parseObject(obj.toString());
            date = jsonObject.getString("a200");
            jsonObject.put("state", jsonObject.getString("a65"));
            jsonObject.put("amount", jsonObject.getString("a66"));
            infos.put(date, jsonObject);
            if (date != null && !"".equals(date)) {
                year = date.split("-")[0];
            }
            if (!yearList.contains(year) && !"".equals(year) && null != year) {
                yearList.add(year);
            }
            Collections.sort(yearList);
            Collections.reverse(yearList);
        }
        System.out.println(getTables(yearList, infos, stateDesc));
    }

    private static String getTables(List<String> yearList, Map<String, JSONObject> infos, String stateDesc) {
        StringBuilder contentBuilder =
                new StringBuilder("<table>" +
                        "            <tr>" +
                        "                <th style=\"color: red\"></th>" +
                        "                <th style=\"color: red\"></th>" +
                        "                <th style=\"color: red\">1</th>" +
                        "                <th style=\"color: red\">2</th>" +
                        "                <th style=\"color: red\">3</th>" +
                        "                <th style=\"color: red\">4</th>" +
                        "                <th style=\"color: red\">5</th>" +
                        "                <th style=\"color: red\">6</th>" +
                        "                <th style=\"color: red\">7</th>" +
                        "                <th style=\"color: red\">8</th>" +
                        "                <th style=\"color: red\">9</th>" +
                        "                <th style=\"color: red\">10</th>" +
                        "                <th style=\"color: red\">11</th>" +
                        "                <th style=\"color: red\">12</th>" +
                        "            </tr>" +
                        "        </table>");
        StringBuilder state = null;
        StringBuilder amount = null;
        String[] months = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String key = null;
        for (String year : yearList) {
            state = new StringBuilder().append("<tr><th rowspan=\"2\">" + year + "</th><th>还款状态</th>");
            amount = new StringBuilder().append("</tr><tr><th>").append(stateDesc).append("</th>");
            for (String month : months) {
                key = year + "-" + month;
                if (infos.containsKey(key)) {
                    state.append("<th>" + infos.get(key).getString("state") + "</th>");
                    amount.append("<th>" + infos.get(key).getString("amount") + "</th>");
                } else {
                    state.append("<th>--</th>");
                    amount.append("<th>--</th>");
                }
            }
            contentBuilder = contentBuilder.append("<table>").append(state).append(amount).append("</table>");
        }
        return contentBuilder.toString();
    }
}
