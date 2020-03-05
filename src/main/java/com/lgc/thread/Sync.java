package com.lgc.thread;

/**
 * @author lgc
 **/
public class Sync {
    private int count = 10;

    public void m() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count= " + count);
        }
    }
    public void m1() {
        synchronized (Sync.class) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count= " + count);
        }
    }

    public synchronized void sync() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " + count);
    }

    public static void main(String[] args) {

    }
}
