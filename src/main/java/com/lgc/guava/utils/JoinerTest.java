package com.lgc.guava.utils;

import com.google.common.base.Joiner;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.collect.ImmutableMap.of;

/**
 * @author lgc
 **/
public class JoinerTest {

    static final List<String> stringList = Arrays.asList("google", "guava", "java");
    static final List<String> stringListWithNull = Arrays.asList("google", "guava", "java", null);
    static final Map<String, String> stringMap = of("hello", "guava", "java", "scala");

    public static void main(String[] args) {
        testJoiner();
    }

    static void testJoiner() {
        System.out.println(Joiner.on("#").join(stringList));
        System.out.println(Joiner.on("$").skipNulls().join(stringListWithNull));
        System.out.println(Joiner.on("%").useForNull("xxx").join(stringListWithNull));
        StringBuilder stringBuilder = Joiner.on("%").useForNull("DEFAULT").appendTo(new StringBuilder(), stringListWithNull);
        System.out.println(stringBuilder);
        try (FileWriter fileWriter = new FileWriter(new File(("/Users/lgc/Desktop/guava.txt")))) {
            Joiner.on("^").useForNull("DEFAULT").appendTo(fileWriter, stringListWithNull);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("----user java 8 ----");
        String stream = stringListWithNull.stream().filter(item -> item != null || item != "").collect(Collectors.joining("$"));
        String stream1 = stringListWithNull.stream().map(JoinerTest::defaultDealByStream).collect(Collectors.joining("$"));
        System.out.println(stream);
        System.out.println(stream1);
        System.out.println("---- joiner map ----");
        System.out.println(Joiner.on("$").withKeyValueSeparator("=").join(stringMap));
        try (FileWriter fileWriter = new FileWriter(new File(("/Users/lgc/Desktop/guavaMap.txt")))) {
            Joiner.on("^").withKeyValueSeparator("=").appendTo(fileWriter, stringMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String defaultDealByStream(String param) {
        return param == null || param == "" ? "DEFAULT" : param;
    }
}
