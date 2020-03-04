package com.lgc.guava.utils;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author lgc
 **/
public class SplitterTest {
    //提前预编译提高速度
    static final Pattern compile = Pattern.compile("\\|");

    public static void main(String[] args) {
        testSplitter();
    }

    static void testSplitter() {
        List<String> strings = Splitter.on("|").splitToList("hello|guava|splitter");
        System.out.println(strings);
        List<String> stringOmit = Splitter.on("|").omitEmptyStrings().splitToList("hello|guava|splitter|||");
        System.out.println(stringOmit);
        List<String> stringOmitTrim = Splitter.on("|").trimResults().omitEmptyStrings().splitToList("hello | guava|splitter|||");
        System.out.println(stringOmitTrim);
        List<String> stringFix = Splitter.fixedLength(5).splitToList("abcdefghijklmn");
        System.out.println(stringFix);
        List<String> result = Splitter.on("#").limit(3).splitToList("hello#google#guava#scala#java");
        System.out.println(result);
        List<String> patternList = Splitter.onPattern("\\|").trimResults().omitEmptyStrings().splitToList("hello|google|");
        System.out.println(patternList);

        List<String> patternRex = Splitter.on(compile).trimResults().omitEmptyStrings().splitToList("hello|google|");
        System.out.println(patternRex);
        Map<String, String> listMap = Splitter.on(compile).trimResults().omitEmptyStrings().withKeyValueSeparator("=").split("hello=google|google=guava");
        System.out.println(listMap);
    }
}
