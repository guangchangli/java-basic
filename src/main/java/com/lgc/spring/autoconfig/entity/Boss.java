package com.lgc.spring.autoconfig.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lgc
 * @create 2020-02-26
 **/
@Component
public class Boss {
    private Car car;

    public Car getCar() {
        return car;
    }

    @Autowired
    public Boss(@Autowired Car car) {
        this.car = car;
    }

    //    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }
    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}

