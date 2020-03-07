package com.lgc.basic.singleton;

/**
 * 内部类加载和初始化时创建保证线程安全
 * @author lgc
 **/
public class StaticInnerCreateSingleton {
    public StaticInnerCreateSingleton() {
    }

    private static class inner {
        private static final StaticInnerCreateSingleton INSTANCE = new StaticInnerCreateSingleton();

    }

    public static StaticInnerCreateSingleton getSingleton() {
        return inner.INSTANCE;
    }
}
