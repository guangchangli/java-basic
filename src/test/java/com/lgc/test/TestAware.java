package com.lgc.test;

import com.lgc.spring.aware.AwareConfig;
import com.lgc.spring.aware.Red;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lgc
 * @create 2020-02-26
 **/
public class TestAware {

    @Test
    public void testAware(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AwareConfig.class);
        Red red = applicationContext.getBean(Red.class);
    }
}
