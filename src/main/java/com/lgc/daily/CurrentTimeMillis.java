package com.lgc.daily;

import java.util.concurrent.CountDownLatch;

/**
 * 并发引起的问题
 *
 * @author lgc
 * @create 2020-01-09 9:38 上午
 **/
public class CurrentTimeMillis {


    private static final int COUNT = 100;

    public static void main(String[] args) {
        long beginTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            System.out.println(System.currentTimeMillis());
        }
    }
}

