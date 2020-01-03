package com.lgc.lock;

/**
 * 对象锁
 *
 * @author lgc
 * @create 2020-01-02 5:04 下午
 **/
public class ObjLock {

    synchronized static void demo() {
        try {
            System.out.println("currentThreadName: " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread0 = new Thread(() -> ObjLock.demo());
        Thread thread1 = new Thread(() -> ObjLock.demo());
        thread0.start();
        thread1.start();
    }
}
