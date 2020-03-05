package com.lgc.collection.List;

import java.util.ArrayList;

/**
 * @author lgc
 **/
interface IList<T> {
}

class LinkImpl<T> implements IList<T> {
    private class Node {
        private T data;
        private Node next;
    }
}

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
    }
}
