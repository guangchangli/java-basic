package com.lgc.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lgc
 * @create 2020-01-13 9:31 上午
 **/
public class Lgc implements InitializingBean, DisposableBean , BeanPostProcessor {
    public Lgc() {
        System.out.println("lgc no args construct");
    }

    public void init(){
        System.out.println("lgc`c init method out");
    }

    public void destroy1(){
        System.out.println("lgc`s destroy method out");
    }

    @PostConstruct
    public void init2(){
        System.out.println("lgc post construct out");
    }
    @PreDestroy
    public void destroy2(){
        System.out.println("lgc pre destroy out");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("lgc after properties set out");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("lgc disposable out");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization out");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization out");
        return null;
    }
}
