package com.lgc.basic.generictype;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 * 没有泛型 存在强转问题 ClassCastException
 * 有了泛型 不担心强转问题 集合存放的是同类型的数据 可以使用增强 for 循环
 * 也是一种提前处理问题的方式 编译器通过 保证了运行期间不会出问题
 * 泛型是针对编译器的 编译完成后的 class 不存在泛型信息 --泛型擦除
 * 带有泛型的集合赋值给老版本的集合 会进行擦除 保留类型参数上限
 *
 * @author lgc
 **/
public class GpDemo<T> {

    /**
     * 定义泛型方法
     */
    public T gpMethod(T t) {
        System.out.println(t);
        return t;
    }

    /**
     * 定义泛型类
     */
    interface GpI<T> {
        /**
         * ss
         *
         * @param t
         */
        void show(T t);
    }

    /**
     * 子类明确泛型 ｜ 不明确
     */
    static class GpIk implements GpI<String> {

        @Override
        public void show(String s) {

        }
    }

    class GpiDk<T> implements GpI<T> {

        @Override
        public void show(T t) {

        }
    }

    /**
     * 通配符 上限 下限
     */
    public void test(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println();
        }
    }

    static void test1(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        List<String> rawList = Lists.newArrayList();
        //List<Object> list = new ArrayList<>();
        //list=strings;
        //string hashcode 便利
        System.out.println("22".hashCode());
        test1(strings);
    }
}
