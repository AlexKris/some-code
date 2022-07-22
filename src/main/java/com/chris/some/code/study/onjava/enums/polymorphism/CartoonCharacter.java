package com.chris.some.code.study.onjava.enums.polymorphism;

import java.util.Random;
import java.util.function.Supplier;

public enum CartoonCharacter implements Supplier<CartoonCharacter> {
    SLAPPY,
    SPANKY,
    PUNCHY,
    SILLY,
    BOUNCY,
    NUTTY,
    BOB,
    ;

    private final Random random = new Random(47);

    @Override
    public CartoonCharacter get() {
        return values()[random.nextInt(values().length)];
    }
}
