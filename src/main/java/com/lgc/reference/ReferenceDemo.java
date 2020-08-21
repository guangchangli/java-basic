package com.lgc.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/**
 * 引用可以控制对象生命周期 有利于垃圾回收
 *
 * @author lgc
 **/
public class ReferenceDemo {
    public static void main(String[] args) {
        //强引用
        Student student = new Student();
        student = null;
        System.gc();
        System.out.println(student);
        //软引用  jvm内存不足才会回收
        SoftReference<Student> studentSoftReference = new SoftReference<>(new Student());
        System.out.println(studentSoftReference.get());
        System.gc();
        System.out.println(studentSoftReference.get());

        //-Xmx20M
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(Arrays.toString(softReference.get()));
        System.gc();
        System.out.println(Arrays.toString(softReference.get()));

        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println(Arrays.toString(softReference.get()));
        System.out.println("-------弱引用------");
        //弱引用 内存足够也会被回收 只要gc就会回收
        WeakReference<byte[]> weakReference = new WeakReference<byte[]>(new byte[1024 * 1024 * 10]);
        System.out.println(Arrays.toString(weakReference.get()));
        WeakReference<byte[]> weakReference1 = new WeakReference<byte[]>(new byte[1]);
        System.out.println(Arrays.toString(weakReference1.get()));
        System.gc();
        System.out.println(Arrays.toString(weakReference1.get()));
        System.out.println("-------虚引用-------");
        //无法通过虚引用来获取对一个对象的真实引用 get return null
        //虚引用必须与ReferenceQueue一起使用，
        // 当GC准备回收一个对象，如果发现它还有虚引用，就会在回收之前，
        // 把这个虚引用加入到与之关联的ReferenceQueue中。
        ReferenceQueue queue1 = new ReferenceQueue();
        PhantomReference<byte[]> reference = new PhantomReference<byte[]>(new byte[1], queue1);
        System.out.println(reference.get());
        System.out.println(queue1);
        System.out.println("---虚引用---");
    }
}
