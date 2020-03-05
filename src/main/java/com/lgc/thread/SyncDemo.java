package com.lgc.thread;

/**
 * @author lgc
 **/
public class SyncDemo implements Runnable {
    private int count = 10; //volatile
    static Object o = new Object();

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " + count);
    }


    public static void main(String[] args) {
        SyncDemo syncDemo = new SyncDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(syncDemo, "THREAD " + i).start();
        }
    }

}
