package com.lgc.juc;

import java.util.concurrent.FutureTask;

/**
 * @author lgc
 **/
public class ThreadLocalDemo {
   static ThreadLocal<String> threadLocal1=new ThreadLocal<>();
    static ThreadLocal<Integer> threadLocal2=new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(new FutureTask<>(()->{
            threadLocal1.set("a");
            threadLocal2.set(1);
            System.out.println(Thread.currentThread().getName());
            System.out.println(threadLocal1.get());
            System.out.println(threadLocal2.get());
            return null;
        })).start();
        new Thread(new FutureTask<>(()->{
            threadLocal1.set("b");
            threadLocal2.set(2);
            System.out.println(Thread.currentThread().getName());
            System.out.println(threadLocal1.get());
            System.out.println(threadLocal2.get());
            return null;
        })).start();
        new Thread(new FutureTask<>(()->{
            threadLocal1.set("c");
            threadLocal2.set(3);
            System.out.println(Thread.currentThread().getName());
            System.out.println(threadLocal1.get());
            System.out.println(threadLocal2.get());
            return null;
        })).start();
    }
}
