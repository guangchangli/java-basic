package com.lgc.basic.classinit;

/**
 * 静态 -- 非晶静态代码块 --构造
 * @author lgc
 **/
public class Father {
    private int i=test();
    private static int j=method();   //1--5

    static {
        System.out.println("(1)");   //2--1
    }
    Father(){
        System.out.println("(2)");   //7--2 //3--2
    }
    {
        System.out.println("(3)");   //6--3 //2--3
    }
    public int test(){
        System.out.println("(4)");  //执行子类重写的方法
        return 1;
    }
    public static int method(){
        System.out.println("(5)");
        return 1;
    }

}
