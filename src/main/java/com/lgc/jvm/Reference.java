package com.lgc.jvm;

/** 强软弱虚 todo -> threadLocal 弱引用 weakHashMap zeroCopy nio
 * @author lgc
 **/
public class Reference {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }

    public static void main(String[] args) {
        Reference reference = new Reference();
        reference=null;
        System.gc();
    }
}
