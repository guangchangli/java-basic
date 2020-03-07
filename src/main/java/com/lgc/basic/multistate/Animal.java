package com.lgc.basic.multistate;

/**
 * @author lgc
 **/
public class Animal {
    public int month = 2;

    public void eat() {
        System.out.println("动物吃东西");
    }

    public static void main(String[] args) {
        /**
         * 多态 编译时 运行时
         * 运行时状态总是表示子类的状态(引用的变量类型) 实例不具备多态
         */
        Animal a = new Dog();
        Animal b = new Cat();
        a.eat();
        System.out.println(a.month);
        //下面代码编译时会出错
//        a.sleep();
        b.eat();
        System.out.println(b.month);
    }
}

class Dog extends Animal{
    public int month = 3;

    @Override
    public void eat() {
        System.out.println("小狗吃肉");
    }

    public void sleep() {
        System.out.println("小狗睡午觉");
    }
}

class Cat extends Animal{
    public int month = 4;
    @Override
    public void eat() {
        System.out.println("小猫吃鱼");
    }
}


