package com.lgc.test;

import com.lgc.spring.autoconfig.SpringAutoConfig;
import com.lgc.spring.autoconfig.entity.Boss;
import com.lgc.spring.autoconfig.entity.Car;
import com.lgc.spring.autoconfig.service.NameService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lgc
 * @create 2020-02-25
 **/
public class TestAutoConfig {

    @Test
    public void testAutoConfig(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAutoConfig.class);
        NameService nameService = applicationContext.getBean(NameService.class);
        System.out.println(nameService);

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);
        applicationContext.close();
    }
}
