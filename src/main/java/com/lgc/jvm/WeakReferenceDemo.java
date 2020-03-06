package com.lgc.jvm;

import java.lang.ref.WeakReference;

/**
 * @author lgc
 **/
public class WeakReferenceDemo {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
        /**
         * 每个线程自己独立拥有 线程存在 threadLocal 存在
         */
        ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());//装到线程的 map 里面
        System.out.println(tl.get());
        tl.remove();
        System.out.println(tl.get());
    }
}
