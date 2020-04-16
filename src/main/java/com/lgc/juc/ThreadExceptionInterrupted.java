package com.lgc.juc;

/**
 * 异常会释放锁
 *
 * @author lgc
 **/
public class ThreadExceptionInterrupted {
    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        for (int i = 0; i < 10; i++) {
            try {
                count++;
                System.out.println(Thread.currentThread().getName() + " count= " + count);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 5) {
                try {
                    System.out.println(2 / 0);
                    //不处理会出问题
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadExceptionInterrupted threadExceptionInterrupted = new ThreadExceptionInterrupted();
        Runnable r = threadExceptionInterrupted::m;
        new Thread(r, "t1").start();
        new Thread(r, "t2").start();
    }
}
