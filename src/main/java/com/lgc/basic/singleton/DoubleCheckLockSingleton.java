package com.lgc.basic.singleton;

/** Double Check Lock
 *  对象创建过程
 *            1。new   分配内存布局 设置默认值
 *            2。invokespecial 构造
 *            3。astore
 *   指令重排 可能会返回半成品的对象
 * @author lgc
 **/
public class DoubleCheckLockSingleton {
    private static volatile DoubleCheckLockSingleton INSTANCE;

    public DoubleCheckLockSingleton() {
    }

    private static DoubleCheckLockSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new DoubleCheckLockSingleton();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(getInstance().hashCode());
            }).start();
        }
    }
}
