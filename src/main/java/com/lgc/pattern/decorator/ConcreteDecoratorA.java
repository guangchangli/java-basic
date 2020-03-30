package com.lgc.pattern.decorator;

public class ConcreteDecoratorA extends Decorator{

    public ConcreteDecoratorA(Apple apple) {
        super(apple);
    }
    
    public void resA(){
        System.out.println("被装饰器A扩展的功能");
    }

    @Override
    public void res(){
        System.out.println("装饰器A=>装饰成红色的");
        super.res();
        System.out.println("装饰器A=>装饰结束");
    }
}