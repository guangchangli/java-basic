package com.lgc.lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * @author lgc
 * @create 2020-01-13 2:24 下午
 **/
public class LambdaInCollection {
    public static void main(String[] args) {
//        removeIf();
//        forEach();
//        replaceAll();
//        sort();
        spliterator();
    }

    static void forEach() {
        List<String> strings = Arrays.asList("na", "xie", "ni", "an", "de", "huang", "tou", "fa", " nv", "hai");
        for (String string : strings) {
            if (string.length() > 3)
                System.out.println(string);
        }

        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if (s.length() > 3)
                    System.out.println(s);
            }
        });

        strings.forEach(s -> {
            if (s.length() > 3)
                System.out.println(s);
        });
    }

    static void removeIf() {
        /**
         * 转换的 list 不能改变大小
         */
        List<String> strings = new ArrayList<>(Arrays.asList("na", "xie", "ni", "an", "de", "huang", "tou", "fa", " nv", "hai"));
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() > 3)
                iterator.remove();
        }
        System.out.println(strings.size());

        System.out.println("-----lambda-----");

        ArrayList<String> list = new ArrayList<>(Arrays.asList("2020", "04", "17", "shanghai", "chen", "yi", "xun", "yan,chang,hui"));
        list.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 3;
            }
        });
        System.out.println(list);

        list.removeIf(s -> s.length() > 3);
        System.out.println(list.size());
        // Array.asList 后面只能是对象｜对象数组
        /**
         * asList 方法返回的确实是一个 ArrayList ,但这个 ArrayList 并不是 java.util.ArrayList ，
         *   而是 java.util.Arrays 的一个内部类。这个内部类用一个 final 数组来保存元素，
         *   因此用 asList 方法产生的 ArrayList 是不可修改大小的
         */
//        List<int[]> ints = Arrays.asList(new int[]{1, 2, 3});
//        System.out.println(ints.size());
//        int[] ints1 = ints.get(0);
//        System.out.println(ints1.length);

        int[] arr = new int[]{1, 2, 3};
        List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(collect.size());
    }

    static void replaceAll() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("2020", "1", "13", "i", "am", "sick"));
        System.out.println(list);
        for (String s : list) {
            if (s.length() > 3) {
                list.set(list.indexOf(s), s.toUpperCase());
            }
        }
        System.out.println(list);
        System.out.println("-----lambda-----");
        ArrayList<String> li = new ArrayList<>(Arrays.asList("2020", "1", "13", "i", "am", "sick"));
        System.out.println(li);
        li.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                if (s.length() > 3)
                    return s.toUpperCase();
                return s;
            }
        });
        System.out.println(li);
        ArrayList<String> st = new ArrayList<>(Arrays.asList("2020", "1", "13", "i", "am", "sick"));
        System.out.println(st);
        st.replaceAll(s -> {
            if (s.length() > 3)
                return s.toUpperCase();
            return s;
        });
        System.out.println(st);
    }

    static void sort(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("shi", "ni,an", "zhi", "qi,an"));
        System.out.println(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        System.out.println(list);
        System.out.println("-----lambda-----");
        List<String> strings = Arrays.asList("ke", "sou", "zh,en", "nan", "sh,ou");
        System.out.println(strings);
        strings.sort((s1,s2)->s1.length()-s2.length());
        System.out.println(strings);
        strings.sort(Comparator.comparingInt(String::length));
        System.out.println(strings);
    }

    static void spliterator(){
        List<String> strings = Arrays.asList("左", "夜", "雨疏风骤", "试问", "卷帘人", "却道", "海棠依旧");
        Spliterator<String> spliterator = strings.spliterator();
        spliterator.forEachRemaining(s -> System.out.println(s));
    }
}
