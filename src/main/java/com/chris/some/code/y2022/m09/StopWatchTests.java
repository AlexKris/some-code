package com.chris.some.code.y2022.m09;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.StopWatch;

import java.util.concurrent.TimeUnit;

public class StopWatchTests {

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = DateUtil.createStopWatch();
        stopWatch.start();
        Thread.sleep(1000);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint(TimeUnit.MILLISECONDS));
    }
}
