package com.lgc.pattern.decorator;

public class ConcreteDecoratorB extends Decorator{

    public ConcreteDecoratorB(Apple apple) {
        super(apple);
    }
    
    public void resB(){
        System.out.println("被装饰器B扩展的功能");
    }

    @Override
    public void res(){
        System.out.println("装饰器B=>装饰成绿色的");
        System.out.println("装饰器B=>装饰结束");
    }
}