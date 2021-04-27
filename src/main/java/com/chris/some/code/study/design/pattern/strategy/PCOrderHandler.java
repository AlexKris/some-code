package com.chris.some.code.study.design.pattern.strategy;

@OrderHandlerType(source = "pc", payMethod = "zfb")
public class PCOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("处理PC端订单");
    }
}
