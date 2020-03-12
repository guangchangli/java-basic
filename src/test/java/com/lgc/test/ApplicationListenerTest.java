package com.lgc.test;

import com.lgc.spring.applicationlistener.MyApplicationListener;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lgc
 **/
public class ApplicationListenerTest {

    @Test
    public void testEvent() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyApplicationListener.class);
        /**
         * 发布事件
         *
         */
        applicationContext.publishEvent(new ApplicationEvent("我的事件") {
        });
        applicationContext.close();
    }
}
