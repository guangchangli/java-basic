package com.lgc.pattern.decorator;

public class ConcreteApple implements Apple {
    @Override
    public void res() {
        System.out.println("普通的苹果");
    }
}