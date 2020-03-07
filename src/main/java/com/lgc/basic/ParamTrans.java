package com.lgc.basic;

import java.util.Arrays;

/**
 * @author lgc
 **/
public class ParamTrans {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 200;
        int[] arr = {1, 2, 3, 4, 5};
        MyData my = new MyData();
        change(i, str, num, arr, my);
        System.out.println("---------");
        System.out.println("i= " + i);  //1
        System.out.println("str= " + str);  //hello
        System.out.println("num= " + num); //2
        System.out.println("arr= " + Arrays.toString(arr)); //22345
        System.out.println("my.a= " + my.a);//11

        System.out.println("-------");
        out(127);
        out(128);
        System.out.println(Integer.valueOf(128).toString());


    }

    static void out(int n) {
        System.out.println("param is " + n);
        /**
         * this method should generally be used in preference to
         *      * the constructor
         *      valueOf优于构造 从缓存取 caceh 的 int 数组
         */
        Integer integer = Integer.valueOf(n);
        Integer integer1 = new Integer(n);
        Integer integer2 = n;
        System.out.print(integer.equals(integer1));
        System.out.println(" integer==integer1 ");
        System.out.print(integer1.equals(integer2));
        System.out.println(" integer1==integer2 ");
        System.out.print(integer.equals(integer2));
        System.out.println(" integer==integer2 ");
    }

    static void change(int j, String s, Integer n, int[] a, MyData m) {
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
        System.out.println("i= " + j);  //1
        System.out.println("str= " + s);  //hello
        System.out.println("num= " + n); //2
        System.out.println("arr= " + Arrays.toString(a)); //22345
        System.out.println("my.a= " + m.a);//11
    }
}

class MyData {
    int a = 10;
}
