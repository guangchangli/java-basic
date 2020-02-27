package com.lgc.test;

import com.lgc.spring.aop.AopConfig;
import com.lgc.spring.aop.MathCalculator;
import com.lgc.spring.aop.MyService;
import com.lgc.spring.aop.ServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * @author lgc
 * @create 2020-02-27
 **/
public class TestAop {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
//        mathCalculator.div(1,0);
        mathCalculator.testArgs(1);
        MyService myService = applicationContext.getBean(MyService.class);
        myService.query();
        myService.query1("args");
//        List<String> strings = Arrays.asList(applicationContext.getBeanDefinitionNames());
//        strings.forEach(System.out::println);
        /**
         * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
         * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
         * org.springframework.context.annotation.internalCommonAnnotationProcessor
         * org.springframework.context.event.internalEventListenerProcessor
         * org.springframework.context.event.internalEventListenerFactory
         * org.springframework.aop.config.internalAutoProxyCreator
         */
        applicationContext.close();
    }
}
