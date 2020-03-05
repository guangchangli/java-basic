package com.lgc.thread;

/**
 * cache
 * @author lgc
 **/
public class CacheLinePadding {
    private static class Padding {
        public volatile long x = 0L;
    }

    class T extends Padding{
        public  volatile long arr=0L;
    }
//
//    Thread t1=new Thread(()->{
//        for (long i = 0; i < 1000_0000L; i++) {
//            arr[0]=i;
//        }
//    });
//    Thread t2=new Thread(()->{
//        for (long i = 0; i < 1000_0000L; i++) {
//            arr[1]=i;
//        }
//    });
    public static void main(String[] args) {

    }
}
