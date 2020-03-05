package com.lgc.thread;

/**
 * synchronized 可重入 必须可重入 父子继承super调用就死锁
 * @author lgc
 **/
public class Reentrant {

    synchronized void m1(){
        System.out.println("m1 start ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end ...");
    }
    synchronized void m2(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 end ...");
    }

    public static void main(String[] args) {
        new Reentrant().m1();
    }
}
