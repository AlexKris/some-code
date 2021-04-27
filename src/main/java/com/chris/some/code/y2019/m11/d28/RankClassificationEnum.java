package com.chris.some.code.y2019.m11.d28;

public enum RankClassificationEnum {

    RANK_PARAM1("10", "正常"),
    RANK_PARAM2("-10", "关注"),
    RANK_PARAM3("-20", "次级"),
    RANK_PARAM4("-30", "可疑"),
    RANK_PARAM5("-40", "损失"),
    RANK_PARAM6("0", "未知"),

    /**
     * 民生银行五级分类对应码表
     */
    //00-正常  01-关注 02-次级   03-可疑    04-损失  05-未知
    MSRANK_PARAM_00("正常", "00"),
    MSRANK_PARAM_01("关注", "01"),
    MSRANK_PARAM_02("次级", "02"),
    MSRANK_PARAM_03("可疑", "03"),
    MSRANK_PARAM_04("损失", "04"),
    MSRANK_PARAM_05("未知", "05"),
    ;

    private String code;
    private String name;


    RankClassificationEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static String getName(String code) {
        for (RankClassificationEnum intf : RankClassificationEnum.values()) {
            if (intf.getCode().equals(code)) {
                return intf.getName();
            }
        }
        return null;
    }

    public static String getCode(String name) {
        for (RankClassificationEnum intf : RankClassificationEnum.values()) {
            if (intf.getName().equals(name)) {
                return intf.getCode();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
