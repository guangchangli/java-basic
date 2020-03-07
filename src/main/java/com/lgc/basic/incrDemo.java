package com.lgc.basic;

/**
 * @author lgc
 **/
public class incrDemo {
    public static void main(String[] args) {
        int i = 1;
        i = i++;     //i=1
        int j = i++; //j=1 i=2
        int k = i + ++i * i++; // 2+3*3  i=4
        System.out.println("i= " + i); //4
        System.out.println("j= " + j); //1
        System.out.println("k= " + k); //11
    }
}
