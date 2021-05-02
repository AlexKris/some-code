package com.chris.some.code.y2020.m09.d01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamGroupingByTest {

    public static void main(String[] args) {
        List<CreditPbcSummary> creditPbcSummaryList = new ArrayList<>();
        CreditPbcSummary creditPbcSummary1 = new CreditPbcSummary();
        creditPbcSummary1.setRoleTyp("01");
        creditPbcSummary1.setIntfSeq("1001");
        creditPbcSummary1.setCode("9999");
        creditPbcSummaryList.add(creditPbcSummary1);

        CreditPbcSummary creditPbcSummary2 = new CreditPbcSummary();
        creditPbcSummary2.setRoleTyp("05");
        creditPbcSummary2.setIntfSeq("1002");
        creditPbcSummary2.setCode("9999");
        creditPbcSummaryList.add(creditPbcSummary2);

        CreditPbcSummary creditPbcSummary3 = new CreditPbcSummary();
        creditPbcSummary3.setRoleTyp("01");
        creditPbcSummary3.setIntfSeq("1003");
        creditPbcSummary3.setCode("9016");
        creditPbcSummaryList.add(creditPbcSummary3);

        CreditPbcSummary creditPbcSummary4 = new CreditPbcSummary();
        creditPbcSummary4.setRoleTyp("05");
        creditPbcSummary4.setIntfSeq("1004");
        creditPbcSummary4.setCode("0000");
        creditPbcSummaryList.add(creditPbcSummary4);

        CreditPbcSummary creditPbcSummary5 = new CreditPbcSummary();
        creditPbcSummary5.setRoleTyp("02");
        creditPbcSummary5.setIntfSeq("1005");
        creditPbcSummary5.setCode("0000");
        creditPbcSummaryList.add(creditPbcSummary5);

        CreditPbcSummary creditPbcSummary6 = new CreditPbcSummary();
        creditPbcSummary6.setRoleTyp("01");
        creditPbcSummary6.setIntfSeq("1003");
        creditPbcSummary6.setCode("9016");
        creditPbcSummaryList.add(creditPbcSummary6);

        CreditPbcSummary creditPbcSummary7 = new CreditPbcSummary();
        creditPbcSummary7.setRoleTyp("05");
        creditPbcSummary7.setIntfSeq("1004");
        creditPbcSummary7.setCode("0000");
        creditPbcSummaryList.add(creditPbcSummary7);

        System.out.println("creditPbcSummaryList = " + creditPbcSummaryList);

        List<CreditPbcSummary> filterCollect = creditPbcSummaryList.stream().filter(
                summary -> "01,05".contains(summary.getRoleTyp())
        ).collect(Collectors.toList());

        System.out.println("filterCollect = " + filterCollect);

        List<CreditPbcSummary> filterCollect0105Success = filterCollect.stream().filter(
                summary -> "01".equals(summary.getRoleTyp()) && ("0000".equals(summary.getCode()) || "9016".equals(summary.getCode())) ||
                        "05".equals(summary.getRoleTyp()) && ("0000".equals(summary.getCode()) || "9016".equals(summary.getCode()))
        ).collect(Collectors.toList());

        System.out.println("filterCollect0105Success = " + filterCollect0105Success);

        Map<String, Long> collect = filterCollect.stream().filter(
                summary -> "0000,9016".contains(summary.getCode()) //||
//                        "9016".equals(summary.getCode())
        ).collect(Collectors.groupingBy(CreditPbcSummary::getCode, Collectors.counting()));

        System.out.println("collect = " + collect);

        Set<CreditPbcSummary> set = creditPbcSummaryList.stream()
                .filter(summary -> "01,05".contains(summary.getRoleTyp()))
                .filter(summary -> "0000".equals(summary.getCode()) || "9016".equals(summary.getCode()))
                .collect(Collectors.toSet());

        System.out.println("set = " + set);

        Map<String, String> map = creditPbcSummaryList.stream()
                .filter(summary -> "01,05".contains(summary.getRoleTyp()))
                .filter(summary -> "0000".equals(summary.getCode()) || "9016".equals(summary.getCode()))
                .distinct()
                .collect(Collectors.toMap(CreditPbcSummary::getRoleTyp, CreditPbcSummary::getIntfSeq));

        System.out.println("map = " + map);

        List<String> list = creditPbcSummaryList.stream()
                .filter(summary -> "01,05".contains(summary.getRoleTyp()))
                .filter(summary -> "0000".equals(summary.getCode()) || "9016".equals(summary.getCode()))
                .map(CreditPbcSummary::getIntfSeq)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("list = " + list);
    }
}
