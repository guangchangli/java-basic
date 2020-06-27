package com.lgc.juc;

/**
 * 第5006168次 ( x= 0 y= 0 a= 1 b= 1)
 *
 * @author lgc
 **/
public class PcDisOrder1 {
    volatile int a = 1;
    volatile int b = 2;

    public PcDisOrder1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public PcDisOrder1() {
    }

    @Override
    public String toString() {
        return "PcDisOrder1[" +
                "a=" + a +
                ", b=" + b +
                ']';
    }

    void write() {
        a = 3;
        b = a;
    }

    void read() {
        if (a==1&&b==3) {
            System.out.println(this + " a:" + a + " b:" + b);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            PcDisOrder1 pcDisOrder1 = new PcDisOrder1();
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pcDisOrder1.write();
            });
            Thread thread1 = new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pcDisOrder1.read();
            });
            thread.start();
            thread1.start();
            thread.join();
            thread1.join();
        }
    }
}
