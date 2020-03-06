package com.lgc.basic.generictype;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lgc
 **/
public class EffectiveGt {

    static void testRawType() {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings);
        System.out.println(strings.get(0));//java.lang.Integer cannot be cast to java.lang.String
    }

    /**
     * 注: EffectiveGt.java使用了未经检查或不安全的操作。
     * 注: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。
     * <p>
     * 警告: [unchecked] 对作为原始类型List的成员的add(E)的调用未经过检查
     * list.add("a");
     * ^
     * 其中, E是类型变量:
     * E扩展已在接口 List中声明的Object
     */
    //@SuppressWarnings("unchecked")
    static void unsafeAdd(List list) {
//        list.add("a");
//        list.add(Integer.valueOf(1));
    }

    static void testRawType1() {
        List<String> strings = new ArrayList<>();
//        unsafeAdd1(strings);
        System.out.println(strings.get(0));
    }

    static void unsafeAdd1(List<Object> list) {
//        list.add(Integer.valueOf(1));
    }

    static void testInstanceOf() {
        Set<Object> set = new HashSet<>();
        if (set instanceof Set) {
            Set<?> set1 = (Set<?>) set;
        }
    }

    static Set<?> testCheck() {
        /**
         * 警告: [unchecked] 未经检查的转换
         *         Set<String> set=new HashSet();
         *                         ^
         *   需要: Set<String>
         *   找到:    HashSet
         */
        @SuppressWarnings("unchecked")
        Set<String> set = new HashSet();
//        Set<String> set=new HashSet<>();
        return set;
    }


    public static void main(String[] args) {
        testRawType();
//        testRawType1();
        System.out.println(int.class);
        System.out.println(List.class);
        System.out.println(String[].class);
    }
}
