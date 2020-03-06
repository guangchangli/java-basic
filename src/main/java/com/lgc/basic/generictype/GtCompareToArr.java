package com.lgc.basic.generictype;

/** 列表优于数组
 *  数组是协变的 数组是具体化的 会在运行时知道和强化元素类型
 *  泛型是可变的 泛型是通过擦除实现的 只在编译器强化类型信息 运行时丢弃(擦除) 可以使泛型与没有使用泛型的代码随意互用
 * @author lgc
 **/
public class GtCompareToArr {
    public static void main(String[] args) {
        /**
         * [] 编译不出错 runtime 出错
         */
        Object[] objects = new Long[1];
        //java.lang.ArrayStoreException: java.lang.String
//        objects[0]="i`m not fit in";
        /**
         * list incompatible type  列表会编译暴露错误
         */
//        List<Object> list = new ArrayList<Long>();
//        list.add("i`m not fit in");

        /**
         * 不能创建泛型数组 可以创建通配符类型的数组
         *
         */
    }

}
