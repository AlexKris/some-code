package com.chris.some.code.study.design.pattern.strategy;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private Map<String, OrderHandler> orderHandlerMap;
    private Map<OrderHandlerType, OrderHandler> orderHandleMap;

    public void setOrderHandlerMap(List<OrderHandler> orderHandlers) {
        // 注入各种类型的订单处理类
        orderHandlerMap = orderHandlers.stream().collect(
                Collectors.toMap(orderHandler -> AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class).source(),
                        v -> v, (v1, v2) -> v1));
    }

    public void setOrderHandleMap(List<OrderHandler> orderHandlers) {
        // 注入各种类型的订单处理类
        orderHandleMap = orderHandlers.stream().collect(
                Collectors.toMap(orderHandler -> AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class),
                        v -> v, (v1, v2) -> v1));
    }

    public void orderService(Order order) {
        // ...一些前置处理

        // 通过订单来源确以及支付方式获取对应的handler
        OrderHandlerType orderHandlerType = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());
        OrderHandler orderHandler = orderHandleMap.get(orderHandlerType);
        orderHandler.handle(order);

        // ...一些后置处理
    }

    public void orderService(Order order, int first, int second) {
        // ...一些前置处理

        // 通过订单来源确定对应的handler
        OrderHandler orderHandler = orderHandlerMap.get(order.getSource());
        orderHandler.handle(order);

        // ...一些后置处理
    }

    public void orderService(Order order, int first) {
        if (order.getSource().equals("pc")) {
            // 处理pc端订单的逻辑
        } else if (order.getSource().equals("mobile")) {
            // 处理移动端订单的逻辑
        } else {
            // 其他逻辑
        }
    }
}
