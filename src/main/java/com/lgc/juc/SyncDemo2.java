package com.lgc.juc;

/**
 * @author lgc
 **/
public class SyncDemo2 implements Runnable {
    int count=10;
    static Object o=new Object();
    @Override
    public void run() {
        synchronized (o){
            count--;
            System.out.println(Thread.currentThread().getName()+" count= "+count);
        }
    }

    public static void main(String[] args) {
        SyncDemo2 syncDemo2 = new SyncDemo2();
        for (int i = 0; i < 10; i++) {
            new Thread(syncDemo2,"THREAD "+i).start();
        }
    }
}
