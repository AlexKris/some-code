package com.chris.some.code.y2020.m11.d20;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreamStored {
    public static void main(String[] args) {
        List<CreditPbcSummary> creditPbcSummaryList1 = new ArrayList<>();
        CreditPbcSummary creditPbcSummary11 = new CreditPbcSummary();
        creditPbcSummary11.setId(397209);
        creditPbcSummary11.setRoleTyp("01");
        creditPbcSummary11.setIntfSeq("30877363");
        creditPbcSummary11.setCode("0000");
        creditPbcSummary11.setActiveFlag("A");
        creditPbcSummary11.setCloneFlag("Y");
        creditPbcSummary11.setQueryDt("2020-09-29 08:20:09");
        creditPbcSummaryList1.add(creditPbcSummary11);

        CreditPbcSummary creditPbcSummary12 = new CreditPbcSummary();
        creditPbcSummary12.setId(397175);
        creditPbcSummary12.setRoleTyp("01");
        creditPbcSummary12.setIntfSeq("30877363");
        creditPbcSummary12.setCode("0000");
        creditPbcSummary12.setActiveFlag("A");
        creditPbcSummary12.setCloneFlag("Y");
        creditPbcSummary12.setQueryDt("2020-09-28 19:03:47");
        creditPbcSummaryList1.add(creditPbcSummary12);

        CreditPbcSummary creditPbcSummary13 = new CreditPbcSummary();
        creditPbcSummary13.setId(397089);
        creditPbcSummary13.setRoleTyp("01");
        creditPbcSummary13.setIntfSeq("30877363");
        creditPbcSummary13.setCode("0000");
        creditPbcSummary13.setActiveFlag("A");
        creditPbcSummary13.setCloneFlag("N");
        creditPbcSummary13.setQueryDt("2020-09-28 17:56:12");
        creditPbcSummaryList1.add(creditPbcSummary13);

        List<CreditPbcSummary> testSorted = creditPbcSummaryList1.stream().filter(summary -> "0000".equals(summary.getCode()))
                .sorted(Comparator.comparingInt(CreditPbcSummary::getId).reversed())
                .limit(1)
                .collect(Collectors.toList());
        System.out.println("testSorted = " + testSorted);
    }
}

@Data
class CreditPbcSummary {
    private Integer id;
    private String roleTyp;
    private String intfSeq;
    private String code;
    private String activeFlag;
    private String cloneFlag;
    private String queryDt;
}
