package com.lgc.reference;

/**
 * @author lgc
 **/
public class Student {
    String name;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("被回收了");
    }
}
