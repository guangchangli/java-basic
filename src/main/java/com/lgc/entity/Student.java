package com.lgc.entity;

import lombok.Data;

/**
 * @author lgc
 * @create 2020-01-06 7:10 下午
 **/
@Data
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
