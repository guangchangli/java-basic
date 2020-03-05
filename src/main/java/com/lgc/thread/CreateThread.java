package com.lgc.thread;

import java.util.concurrent.Callable;

/**
 * @author lgc
 **/
public class CreateThread {
    /**
     * start run
     * start 会创建新的线程 状态转为 Runnable 获取到cpu执行 调用run() 不可以多次调用
     * run jvm 调用 可以多次调用
     */
    static class ExtendThread extends Thread {
        @Override
        public void run() {
            System.out.println("extend thread create thread");
        }
    }

    static class ImplementsThread implements Runnable {
        @Override
        public void run() {
            System.out.println("implements Runnable create thread");
        }
    }
    static class Implements implements Callable{

        @Override
        public Object call() throws Exception {
            return null;
        }
    }

    public static void main(String[] args) {
        new ExtendThread().start();
        new Thread(new ImplementsThread()).start();
//        ThreadPoolExecutor
    }

}
