package com.lgc.pattern.decorator;

public abstract class Decorator implements Apple {

    protected Apple apple;

    public Decorator(Apple apple) {
        this.apple = apple;
    }
    @Override
    public void res() {
        apple.res();
    }
    
}