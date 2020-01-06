package com.lgc.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lgc
 * @create 2020-01-06 7:19 下午
 **/
public class TestLifeCycle {
    public static void main(String[] args) {
        System.out.println("------start spring ioc ------");
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(CustomerLifeCycleConfig.class);
        System.out.println("------ spring ioc getBean redCar ------");
        annotationConfigApplicationContext.getBean("redCar");
        annotationConfigApplicationContext.close();
        System.out.println("------close spring ioc -------");

        /**
         * ------start spring ioc ------
         * ------ spring ioc getBean redCar ------
         * ------config start inject redCar------
         * ---1.after car construct                 @postConstruct
         * ---2.cat propertiesSet finished          @AfterProperties
         * ---3.initMethod init car                 @Bean(initMethod="")
         * ---4.ready to destroy car                @PreDestroy
         * ---5.destroyMethod destroy car           @Bean(destroyMethod="")
         * ------close spring ioc -------
         */
    }
}
