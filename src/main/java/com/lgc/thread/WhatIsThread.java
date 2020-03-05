package com.lgc.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author lgc
 **/
public class WhatIsThread {

    public static void main(String[] args) {
//        new T1().run();
        new T1().start();
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
                System.out.println("main");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }
}
