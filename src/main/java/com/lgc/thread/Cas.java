package com.lgc.thread;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author lgc
 **/
public class Cas {
    public static void main(String[] args) {
        Object o = new Object();
        o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
