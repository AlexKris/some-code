package com.chris.some.code.y2019.m06.d19;

public class TestGC {
    public static void main(String[] args) {
        ReferenceCountingGc.testGC();
    }
}

class ReferenceCountingGc {
    private Object instance = null;
    private static final int MB = 1024 * 1024;
    private final byte[] bugSize = new byte[2 * MB];

    static void testGC() {
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }
}