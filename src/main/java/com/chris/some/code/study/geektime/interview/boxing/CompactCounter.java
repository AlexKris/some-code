package com.chris.some.code.study.geektime.interview.boxing;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class CompactCounter {

    private volatile long counter;

    private static final AtomicLongFieldUpdater<CompactCounter> UPDATER = AtomicLongFieldUpdater.newUpdater(CompactCounter.class, "counter");

    public void increase() {
        UPDATER.incrementAndGet(this);
    }
}
