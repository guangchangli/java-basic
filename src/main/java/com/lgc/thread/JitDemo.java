package com.lgc.thread;

/**
 * JIT Just In Time
 *
 * @author lgc
 **/
public class JitDemo {
    static volatile int i = 0;

    public static void main(String[] args) {
        for (int j = 0; j < 1000000; j++) {
            m();
            n();
        }
    }

    static synchronized void m() {

    }

    static void n() {
        i = 1;
    }
}

