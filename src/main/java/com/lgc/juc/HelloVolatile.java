package com.lgc.juc;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author lgc
 **/
public class HelloVolatile {
    volatile boolean running = true;

    void m() {
        System.out.println("m start ");
        while (running) {
        }
        System.out.println("m end");
    }

    @SneakyThrows
    public static void main(String[] args) {
        HelloVolatile t = new HelloVolatile();
        new Thread(t::m, "t1").start();
        TimeUnit.SECONDS.sleep(1);
        t.running = false;
    }
}
