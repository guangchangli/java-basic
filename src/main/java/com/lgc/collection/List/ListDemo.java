package com.lgc.collection.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lgc
 */
public class ListDemo {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        List<Object> objects1 = new LinkedList<>();
        System.out.println(10+(10>>1));
        System.out.println(15+(15>>1));
        System.out.println(8>>>1);
        System.out.println(new Object().hashCode());
    }
}
