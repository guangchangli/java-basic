package com.lgc.stream;

import com.google.common.collect.Lists;
import com.lgc.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 创建流
 *
 * @author lgc
 * @create 2020-01-06 6:02 下午
 **/
public class CreateStream {
    public static void main(String[] args) {

        // 1. collection.stream() / parallelStream()
        List<String> list = Lists.newArrayListWithCapacity(5);
        list.add("l");
        list.add("g");
        list.add("c");
        Stream<String> listStream = list.stream();
        System.out.println(listStream.collect(Collectors.toList()));

        // 2. Arrays.stream()//Stream.of()
        Stream<List<Integer>> arrayStream = Stream.of(Arrays.asList(1, 2, 3));
        System.out.println(arrayStream.collect(Collectors.toList()));
        //todo asList BUG

        // 3. bufferedReaders

//  --------------- 流的类型
        // 1.普通流
        List<String> strs = new ArrayList<>();
        Stream<String> stream = strs.stream();
        // 2.并行流
        Stream<String> stringStream = strs.parallelStream();
        // 3.空
        Stream<Object> empty = Stream.empty();
        // 4.无限流
        Stream.generate(() -> "number" + new Random().nextInt()).limit(100).forEach(System.out::println);
        Stream.generate(() -> new Student("name", 10)).limit(20).forEach(System.out::println);

        //产生规律数据
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);
        Stream.iterate(0, x -> x).limit(10).forEach(System.out::println);
        //Stream.iterate(0,x->x).limit(10).forEach(System.out::println);与如下代码意思是一样的
        Stream.iterate(0, UnaryOperator.identity()).limit(10).forEach(System.out::println);

    }
}
