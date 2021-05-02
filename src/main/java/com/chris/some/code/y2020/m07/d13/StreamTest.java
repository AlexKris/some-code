package com.chris.some.code.y2020.m07.d13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        String provinceAreaCode = "350000";
        List<String> bchProvinceList = Arrays.asList("120000", "210000", "410000", "140000", "440000", "530000", "130000", "340000", "430000", "520000");
        List<Area> provinceList = new ArrayList<>();
        Area tianjin = new Area();
        tianjin.setAreaCode("120000");
        tianjin.setAreaName("天津市");
        provinceList.add(tianjin);
        Area hebei = new Area();
        hebei.setAreaCode("130000");
        hebei.setAreaName("河北省");
        provinceList.add(hebei);
        Area shanxi = new Area();
        shanxi.setAreaCode("140000");
        shanxi.setAreaName("山西省");
        provinceList.add(shanxi);
        Area liaoning = new Area();
        liaoning.setAreaCode("210000");
        liaoning.setAreaName("辽宁省");
        provinceList.add(liaoning);
        Area anhui = new Area();
        anhui.setAreaCode("340000");
        anhui.setAreaName("安徽省");
        provinceList.add(anhui);
        Area fujian = new Area();
        fujian.setAreaCode("350000");
        fujian.setAreaName("福建省");
        provinceList.add(fujian);
        Area henan = new Area();
        henan.setAreaCode("410000");
        henan.setAreaName("河南省");
        provinceList.add(henan);
        Area hunan = new Area();
        hunan.setAreaCode("430000");
        hunan.setAreaName("湖南省");
        provinceList.add(hunan);
        Area guangdong = new Area();
        guangdong.setAreaCode("440000");
        guangdong.setAreaName("广东省");
        provinceList.add(guangdong);
        Area guizhou = new Area();
        guizhou.setAreaCode("520000");
        guizhou.setAreaName("贵州省");
        provinceList.add(guizhou);
        Area yunnan = new Area();
        yunnan.setAreaCode("530000");
        yunnan.setAreaName("云南省");
        provinceList.add(yunnan);
        String msg = provinceList.stream().filter(area -> bchProvinceList.contains(area.getAreaCode())).map(Area::getAreaName).collect(Collectors.joining("、"));
        if (!bchProvinceList.contains(provinceAreaCode))
            System.out.println("选择邮储专属专案的业务，上牌地仅支持录入" + msg + "范围内的地区");
        else
            System.out.println("通过");
    }
}
