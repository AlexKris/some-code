package com.chris.some.code.y2022.m09;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTests {

    public static void main(String[] args) {
        List<FieldDTO> hisList = new ArrayList<>();
        hisList.add(new FieldDTO("ext_agency_credit", "f1", "1", "2"));
        hisList.add(new FieldDTO("ext_agency", "f2", "ceshi", "zaiceshi"));
        hisList.add(new FieldDTO("ext_agency_margin", "f3", "1000.00", ""));
        hisList.add(new FieldDTO("ext_agency_margin", "f4", "ceyixia", "zaiceyixia"));
        Set<String> collect = hisList.stream().map(FieldDTO::getOpTable).collect(Collectors.toSet());
        System.out.println("collect = " + collect);
        Map<String, Object> map = hisList.stream().collect(Collectors.toMap(FieldDTO::getOpField, FieldDTO::getNewValue));
        System.out.println("map = " + map);
        EntityDTO entityDTO = BeanUtil.copyProperties(map, EntityDTO.class);
        System.out.println("entityDTO = " + entityDTO.toString());
        Integer integer = 1;
        System.out.println(integer.equals("1"));
    }
}
