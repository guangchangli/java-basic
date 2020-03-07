package com.lgc.basic.classinit;

/**
 * 先初始化父类 静态 clinit
 * 实例初始化 init
 * @author lgc
 **/
public class Son extends Father {
    private int i = test(); //8--9
    private static int j = method();

    static {
        System.out.println("(6)"); //4--6
    }

    Son() {
        System.out.println("(7)"); //10--7  //5--7
    }

    {
        System.out.println("(8)"); //9--8  //4--8
    }

    @Override
    public int test() {
        System.out.println("(9)"); //5--9 //1--9
        return 1;
    }

    public static int method() {
        System.out.println("(10)"); //3--10
        return 1;
    }

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println();
        Son son1 = new Son();
    }

}
