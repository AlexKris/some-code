package com.chris.some.code.y2020.m07.d16;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chris.some.code.util.JacksonUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class TestStreamSort {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("0"));
//        String str = "5,0**,0**";
//        System.out.println(str.replace("*", "0").replace(",", ""));
//        System.out.println(str.replaceAll("\\*", "0").replaceAll(",", ""));
//        BigDecimal bigDecimal1 = testBigDecimal("5,0**");
//        BigDecimal bigDecimal2 = testBigDecimal("￥");
//        System.out.println(bigDecimal1);
//        System.out.println(bigDecimal2);
//        System.out.println(bigDecimal2.compareTo(bigDecimal1.multiply(new BigDecimal("0.9"))) >= 0);
    }


    private static void testStream() {
        Domain domain1 = new Domain("账户1D1");
        Domain domain2 = new Domain("账户2D1");
        Domain domain3 = new Domain("账户3D1");
        Domain domain4 = new Domain("账户4D1");
        Domain domain5 = new Domain("账户5D1");
        Domain domain6 = new Domain("账户6D1");
        Domain domain7 = new Domain("账户7D1");
        Domain domain8 = new Domain("账户8D1");
        Domain domain9 = new Domain("账户9D1");
        Domain domain10 = new Domain("账户10D1");
        Domain domain11 = new Domain("账户11D1");
        Domain domain12 = new Domain("账户12D1");
        Domain domain13 = new Domain("账户13D1");
        Domain domain14 = new Domain("账户14D1");
        Domain domain15 = new Domain("账户15D1");
        Domain domain16 = new Domain("账户16D1");
        Domain domain17 = new Domain("账户17D1");
        Domain domain18 = new Domain("账户18D1");
        Domain domain19 = new Domain("账户19D1");
        Domain domain20 = new Domain("账户20D1");
        Domain domain21 = new Domain("账户21D1");
        Domain domain22 = new Domain("账户22D1");
        Domain domain23 = new Domain("账户23D1");
        Domain domain24 = new Domain("账户24D1");
        Domain domain25 = new Domain("账户25D1");
        Domain domain26 = new Domain("账户26D1");
        Domain domain27 = new Domain("账户27D1");
        Domain domain28 = new Domain("账户28D1");
        Domain domain29 = new Domain("账户29D1");
        List<Domain> domainList = Arrays.asList(
                domain20,
                domain21,
                domain22,
                domain23,
                domain24,
                domain25,
                domain26,
                domain27,
                domain28,
                domain29,
                domain10,
                domain11,
                domain12,
                domain13,
                domain14,
                domain15,
                domain16,
                domain17,
                domain18,
                domain19,
                domain1,
                domain2,
                domain3,
                domain4,
                domain5,
                domain6,
                domain7,
                domain8,
                domain9
        );
        System.out.println(domainList);
        List<Domain> sortedList = domainList.stream().sorted(Comparator.comparing(domain -> Integer.parseInt(domain.getAccountNo().replaceAll("\\D", "")))).collect(Collectors.toList());
        System.out.println(sortedList);
        List<Integer> collect = domainList.stream().map(domain -> Integer.parseInt(domain.getAccountNo().replaceAll("\\D", ""))).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void testBr() {
        String json_result = "{\"swift_number\":\"100126_20200728121042_6240\",\"code\":\"00\",\"Flag\":{\"specialList_c\":\"1\"},\"SpecialList_c\":{\"id\":{},\"cell\":{\"nbank_other_lost\":\"1\",\"p2p_lost\":\"1\"},\"gid\":{},\"lm_cell\":{}}}";
        JSONObject json = JSON.parseObject(json_result);
        //获取百融返回信息标志
        JSONObject flag_result = (JSONObject) json.get("Flag");
        if (flag_result != null) {
            //获取flag中specialList_c的值
            String flag_sp = flag_result.getString("specialList_c");
            //判断百融返回结果有否输出(flag_sp=1则有输出，为0则未命中没输出)
            if ("1".equals(flag_sp)) {
                List<Map<String, Object>> brs = new ArrayList<>();
                //命中黑名单，解析SPECIALLIST_C
                JSONObject main_result = (JSONObject) json.get("SpecialList_c");
                //id信息是否包含
                boolean flag_id = main_result.containsKey("id");
                //cell信息是否包含
                boolean flag_cell = main_result.containsKey("cell");
                //判断是否有id信息,分别入库
                if (flag_id) {
                    String id = main_result.getString("id");
                    Map<String, Object> br = JacksonUtils.jsonToMap(id);
                    //添加类型标号
                    br.put("queryTyp", "01");
                    //添加公共基础信息（流水号、申请人信息、查询时间、查询操作...）
                    brs.add(br);
                }
                //判断是否有cell信息,分别入库
                if (flag_cell) {
                    String cell = main_result.getString("cell");
                    Map<String, Object> br = JacksonUtils.jsonToMap(cell);
                    //添加类型标号
                    br.put("queryTyp", "02");
                    //添加公共基础信息（流水号、申请人信息...）
                    brs.add(br);
                }
                System.out.println(JSON.toJSONString(brs));
            }
        }
    }

    private static void testMap() {
        // paramMap.put("roleTyp", paramMap.getOrDefault("roleTyp", CommonEnum.CAXS_ONE_ROLE_TYPE.getCode()));
        Map<String, Object> map = new HashMap<>();
        map.put("role", "角色");
        Object roleTyp = map.getOrDefault("roleTyp", "01");
        System.out.println(roleTyp);
    }

    private static BigDecimal testBigDecimal(String str) {
        return new BigDecimal(str
                .replace("*", "0")
                .replace("--", "0")
                .replace("￥", "0")
                .replace(",", "")
        );
    }
}
