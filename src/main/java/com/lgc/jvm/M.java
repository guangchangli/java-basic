package com.lgc.jvm;

/**
 * @author lgc
 **/
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
