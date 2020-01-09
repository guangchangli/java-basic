package com.lgc.daily;

/** 对象不使用 置为空 触发gc
 * @author lgc
 * @create 2020-01-09 9:41 上午
 **/
public class ObjectNotUseGc {

    public static void main(String[] args) {
        if (true) {
            byte[] bytes = new byte[1024 * 1024 * 60];
            System.out.println(bytes.length);
            bytes=null;
        }
        System.gc();
    }
}
