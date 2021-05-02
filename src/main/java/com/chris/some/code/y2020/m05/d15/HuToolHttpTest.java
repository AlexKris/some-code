package com.chris.some.code.y2020.m05.d15;

import cn.hutool.core.lang.Assert;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HuToolHttpTest {

    public static void main(String[] args) {
        String json = "{\n" +
                "    \"applCde\": \"202102140000000000401\",\n" +
                "    \"roleTyp\": \"01\",\n" +
                "    \"custName\": \"白户\",\n" +
                "    \"idNo\": \"620101199002140014\",\n" +
                "    \"idTyp\": \"20\",\n" +
                "    \"infoList\": [\n" +
                "        \"acc02\",\n" +
                "        \"det01\",\n" +
                "        \"det02\",\n" +
                "        \"det03\",\n" +
                "        \"det08\",\n" +
                "        \"det12\",\n" +
                "        \"inf34\",\n" +
                "        \"inf12\",\n" +
                "        \"foc01\",\n" +
                "        \"spc03\",\n" +
                "        \"rsp03\",\n" +
                "        \"rsp04\",\n" +
                "        \"rcd01\",\n" +
                "        \"rcd02\",\n" +
                "        \"rcd06\",\n" +
                "        \"com03\",\n" +
                "        \"com04\",\n" +
                "        \"lst02\",\n" +
                "        \"lst05\"\n" +
                "    ]\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(json);
        String url = getUrl();
        Assert.notBlank(url);
        System.out.println(HttpUtil.post(url, jsonObject.toJSONString()));
    }

    static String getUrl() {
        return "http://10.169.169.63:8585/themis_front/secPbcInfo/rules";
    }
}
