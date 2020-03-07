package com.lgc.basic.inner;

public class StaticInnerClass {
    static String gender;
    int money;

    public StaticInnerClass(int money) {
        super();
        this.money = money;
    }


    public void create() {
        Inner inner = new Inner();
        inner.visited();
        System.out.println(inner.age);
        System.out.println(Inner.name);
    }

    /**
     * 静态内部类   * @author MR.W
     */
    static class Inner {
        //静态成员
        static String name;
        //非静态成员
        int age;

        public void visited() {
            //访问外部类静态成员
            System.out.println(gender);
            //访问外部类非静态成员
            System.out.println(new StaticInnerClass(2000).money);
        }
    }
}

class Test1 {
    public static void main(String[] args) {
        //第一种外部类中定义方法，方法内实例化内部类，并实例化外部类，调用该方法（不推荐）
        StaticInnerClass staticInnerClass = new StaticInnerClass(1000);
        staticInnerClass.create();
        //第二种 通过外部类.
        StaticInnerClass.Inner s = new StaticInnerClass.Inner();
        System.out.println(s.age);
        System.out.println(StaticInnerClass.Inner.name);
    }
}