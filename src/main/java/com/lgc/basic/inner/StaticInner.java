package com.lgc.basic.inner;

import com.lgc.basic.BasicJava;

/**
 * 成员内部类 -> 静态内部类 作为外部类的成员 可以访问外部类的静态域
 *
 * @author lgc
 **/
public class StaticInner {
    public static void main(String[] args) {
        //通过外部类才可以访问
        Outer.Inner inner = new Outer.Inner();

    }
}

class Outer {
    private String outerName = "out field";
    static String out = "out";

    static {
        System.out.println("outer load");
        //访问内部类
        System.out.println(new Inner());

    }

    void outerNormalMethod() {
        //访问内部类属性
        Inner inner = new Inner();
        System.out.println(inner.innerName);
        inner.normalMethod();
        Outer.Inner.innerPrint();
        System.out.println(Inner.in);
        /**
         * 局部内部类 局部使用
         */
        final class LocalIn {

        }
        LocalIn localIn = new LocalIn();
        /**
         * 匿名内部类
         */
        new BasicJava(){
            @Override
            public void normal() {
                System.out.println("");
            }
        };
    }

    static void outerPrint() {
        System.out.println("outer print method out");
    }

    /**
     * 静态成员内部类 归属于类
     */
    static class Inner {
        private String innerName = "inner field";
        static String in = "in";

        static {
            System.out.println("inner load");
            //访问外部静态域
            outerPrint();
            System.out.println(out);
        }

        static void innerPrint() {
            System.out.println("inner static method print out");
        }

        void normalMethod() {
            System.out.println("inner normal method out");
        }
    }
}
