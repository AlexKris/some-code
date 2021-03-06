package com.chris.some.code.study.design.pattern.strategy;

@OrderHandlerType(source = "mobile", payMethod = "wx")
public class MobileOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("处理移动端订单");
    }
}
