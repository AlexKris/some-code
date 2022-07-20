package com.chris.some.code.study.onjava.enums.customize;

import java.util.stream.Stream;

/**
 * 重载方法
 *
 * @author grt
 * @since 2022-07-20 17:08:18
 */
public enum SpaceShip {
    SCOUT,
    CARGO,
    TRANSPORT,
    CRUISER,
    BATTLESHIP,
    MOTHERSHIP,
    ;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        Stream.of(values()).forEach(System.out::println);
    }
}
