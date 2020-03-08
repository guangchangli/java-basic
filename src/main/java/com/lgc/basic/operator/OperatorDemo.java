package com.lgc.basic.operator;

/**
 * @author lgc
 **/
public class OperatorDemo {
    public static void main(String[] args) {
//        test();
        test1();
//        test2();
        System.out.println(0|1);
        System.out.println(0|2-1);
        System.out.println(1&0);
        System.out.println(false||true);
        System.out.println(true&&false);
    }

    static void test() {
        int a=1,b=1;
        if (a++ == 1|2==1){
            System.out.println(true);
        }
        System.out.println("test | a= "+a+" b= "+b);
    }
    static void test1(){
        int a=1,b=1;
        if (a++==1||++b==2){
            System.out.println(true);
        }
        System.out.println("test || a= "+a+" b= "+b);
    }
    static void test2(){
        int a=1,b=1;
        if (a++==1 & 2==1){
            System.out.println(true);
        }
        System.out.println("test & a= "+a+" b= "+b);
    }
}
