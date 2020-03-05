package com.lgc.thread;

/**
 * @author lgc
 **/
public class PcDisOrder {
    static int x, y, a, b;

    public static void main(String[] args) throws InterruptedException {
        x = 0;
        y = 0;
        a = 0;
        b = 0;
        for (int i = 0; ; i++) {

            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread two = new Thread(() -> {
                b = 1;
                y = a;
            });
            one.start();
            two.start();
            one.join();
            two.join();
            String result = "第" + "次 (" + " x= " + x + " y= " + y + " a= " + a + " b= " + b + ")";
            if (x == 0 && b == 0) {
                System.out.println(result);
                break;
            }
        }
    }
}
