package com.lgc.basic.singleton;

/**
 * 单例 保证只有一个实例
 * 构造私有化 静态变量保存实例
 * public 公开
 *
 * @author lgc
 **/
public class SingletonDemo {

    private static SingletonDemo instanceLazy;
    public static final SingletonDemo instanceLoad;

    public SingletonDemo() {
    }

    static {
        instanceLoad = new SingletonDemo();
    }

    /**
     * 懒汉 需要在创建
     * @return
     */
    static SingletonDemo getInstanceLazy() throws InterruptedException {
        if (instanceLazy == null) {
            synchronized (SingletonDemo.class) {
                return instanceLazy == null ? instanceLazy = new SingletonDemo() : instanceLazy;
            }
        }
        return instanceLazy;

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

}
