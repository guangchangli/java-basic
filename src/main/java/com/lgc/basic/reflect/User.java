package com.lgc.basic.reflect;

public class User {
    private static int a = 10;
    {
        System.out.println("普通代码块");
    }
    static{
        System.out.println("静态变量a:"+a);
        System.out.println("静态代码块");
    }
}