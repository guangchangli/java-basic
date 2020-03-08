package com.lgc.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lgc
 **/
public class MapDemo {
    public static void main(String[] args) {
        Map<Object, Object> objectObjectHashMap = new HashMap<>();
        Map<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        Map<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
    }
}
