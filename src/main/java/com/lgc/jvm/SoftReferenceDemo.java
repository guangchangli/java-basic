package com.lgc.jvm;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/**
 * @author lgc
 **/
public class SoftReferenceDemo {
    public static void main(String[] args) {
        Reference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
