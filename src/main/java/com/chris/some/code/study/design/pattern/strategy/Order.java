package com.chris.some.code.study.design.pattern.strategy;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    /**
     * 订单来源
     */
    private String source;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 订单编号
     */
    private String code;
    /**
     * 订单金额
     */
    private BigDecimal amount;
}
