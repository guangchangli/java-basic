package com.lgc.juc;

/**
 * @author lgc
 **/
public class ThreadState {
    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.println("isAlive "+t.isAlive());
        System.out.println("isDaemon "+t.isDaemon());
        System.out.println("state "+t.getState());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("state "+t.getState());
        t.interrupt();
        System.out.println("isInterrupted "+t.isInterrupted());
        System.out.println("isAlive "+t.isAlive());
        System.out.println("isDaemon "+t.isDaemon());
    }
}
