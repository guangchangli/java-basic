package com.lgc.basic;

/**
 * 单例 保证只有一个实例
 *
 * @author lgc
 **/
public class SingletonDemo {

    private static SingletonDemo instanceLazy;
    private static SingletonDemo instanceLoad = new SingletonDemo();

    public SingletonDemo() {
    }

    /**
     * 懒汉 需要在创建
     *
     * @return
     */
    static SingletonDemo getInstanceLazy() {
        return instanceLazy == null ? instanceLazy = new SingletonDemo() : instanceLazy;
    }

    /**
     * 饿汉式
     *
     * @return
     */
    static SingletonDemo getInstanceImmediately() {
        return instanceLoad;
    }

    static SingletonDemo getInstanceFromInner() {
        return inner.INS;
    }

    private static class inner {
        private static final SingletonDemo INS = new SingletonDemo();
    }

    void normal(){

    }
}
