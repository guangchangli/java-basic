package com.lgc.juc;

/**
 * 线程状态 new start        os(Runnable)
 *                Ready(调度器)  <--yield (挂起)-- Running(执行)
 *         blocked (锁 sync)
 *         waiting (wait join park)
 *         TimeWaiting(sleep wait join(time) parkNanos() parkUnit() )
 *         Teminated
 *
 *
 * @author lgc
 **/
public class Thread_Sleep_Yield_Join {
    public static void main(String[] args) {

    }

    /**
     * sleep 不释放资源 运行->阻塞
     */
    static void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    // 放弃cpu 让拥有同样优先级的线程获取执行机会 状态转为就绪 等待pu执行 时间片的暂时让出
    static void testYield() {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("A" + i);
                if (i == 3) {
                    Thread.yield();
                }
            }
        }).start();
    }

    // join(0) 死循环 阻塞当前线程 synchronized 调用的是wait()方法 等待其他进程运行完毕 进入就绪状态
    static void testJoin() {
        Thread T1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("T" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread T2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("2");
                    T1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * 对于yield方法，比较容易理解，只是简单地对于CPU时间片的“礼让”，
     * 除非循环yield，否则一次yield，可能下次该线程仍旧可能会抢占到CPU时间片，可能方法调用和不调用没差别。
     *
     * sleep是静态方法，针对当前线程，进入休眠状态，两个版本的sleep方法始终有时间参数，
     * 所以必然会在指定的时间内苏醒，他也不会释放锁，当然，sleep方法的调用非必须在同步方法（同步代码块）内。
     *
     * join是实例方法，表示等待谁，是用于线程顺序的调度方法，可以做到一个线程等待另外一个线程，
     * join有三个版本，指定超时时间或者持续等待直到目标线程执行结束，join也无需在同步方法（同步代码块）内。
     *
     * sleep和join都是可中断方法，被其他线程中断时，都会抛出InterruptedException异常，并且会醒来。
     *
     * join方法底层依赖wait，对比下wait与sleep。
     *
     * wait和sleep都会使线程进入阻塞状态，都是可中断方法，被中断后都会抛出异常
     *
     * wait是Object的方法，sleep是Thread的方法
     *
     * wait必须在同步中执行，sleep不需要（join底层依赖wait，但是不需要在同步中，因为join方法就是synchronized的）
     *
     * wait会释放锁，sleep不会释放锁
     *
     * wait（无超时设置的版本）会持续阻塞，必须等待唤醒，而sleep必然有超时，所以一定会自己醒来
     *
     * wait 实例方法（Object），在对象上调用，表示在其上等待；sleep静态方法，当前线程
     */
}
