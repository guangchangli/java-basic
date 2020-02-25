package com.lgc.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;

/**
 * @author lgc
 * @create 2020-01-06 7:14 下午
 **/
@Configuration
public class CustomerLifeCycleConfig {


    @Bean(initMethod = "initCat", destroyMethod = "destroyCar")
    @Lazy
    public Car redCar() {
        System.out.println("------config start inject redCar------");
        return Car.builder().name("Audi").county("G").price(500000).build();
    }
}
