package com.lgc.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lgc
 * @create 2019-12-18 10:40 上午
 **/
public class GuavaDemo {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayListWithCapacity(2);
        System.out.println(list);
        Map<Object, Object> map = Maps.newHashMap();

    }
}
