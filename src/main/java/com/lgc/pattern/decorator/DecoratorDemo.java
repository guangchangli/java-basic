package com.lgc.pattern.decorator;

/**
 * @author lgc
 **/
public class DecoratorDemo {
    /**
     * 装饰器模式的说明：动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案
     * Attach additional responsibilities to an object dynamically keeping the same interface.
     * Decorators provide a flexible alternative to subclassing for extending functionality.
     * 有效的把类的核心职责和装饰功能区分开，职责更细化
     * @param args
     */
    public static void main(String[] args) {
        Apple apple =new ConcreteApple();
        System.out.println("-----------未装饰-------------------\n");
        apple.res();//原来的方法
        test2(apple) ;
    }
    private static void test2(Apple apple){
        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB(apple);
        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(apple);
        System.out.println("\n-----------装饰后-------------------\n");
        decoratorB.res();
        decoratorA.res();
    }
}
