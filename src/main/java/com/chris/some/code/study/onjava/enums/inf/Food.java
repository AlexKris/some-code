package com.chris.some.code.study.onjava.enums.inf;

/**
 * 可以在一个接口内对元素进行分组，基于这个接口生成一个枚举
 * 实现接口是唯一可以子类化枚举的方式
 *
 * @author grt
 * @since 2022-07-22 16:09:01
 */
public interface Food {
    enum Appetizer implements Food {
        SALAD,
        SOUP,
        SPRING_ROLLS,
    }

    enum MainCourse implements Food {
        LASAGNE,
        BURRITO,
        PAD_THAI,
        LENTILS,
        HUMMUS,
        VINDALOO,
    }

    enum Dessert implements Food {
        TIRAMISU,
        GELATO,
        BLACK_FOREST_CAKE,
        FRUIT,
        CREME_CARAMEL,
    }

    enum Coffee implements Food {
        BLACK_COFFEE,
        DECAF_COFFEE,
        ESPRESSO,
        LATTE,
        CAPPUCCINO,
        TEA,
        HERB_TEA,
    }
}
