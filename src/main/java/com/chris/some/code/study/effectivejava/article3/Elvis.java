package com.chris.some.code.study.effectivejava.article3;

// Singleton with public final field
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    // Singleton with static factory
    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
    }

    // readResolve method to preserve singleton property
    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator
        return INSTANCE;
    }
}
