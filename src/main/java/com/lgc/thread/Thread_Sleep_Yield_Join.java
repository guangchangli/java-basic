package com.lgc.thread;

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
    // 放弃cpu 让拥有同样优先级的线程获取执行机会 状态转为就绪 等待cpu执行
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
}
