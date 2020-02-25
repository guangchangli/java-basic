package com.lgc.spring.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * bean实例过程
 * 实例bean -->     设置bean属性 -->     检查Aware相关接口并设置相关依赖 --
 * ｜
 * ｜
 * ｜
 * ｜  是否有自定义 init-method <-- 是否是InitializingBean是否调用afterPropertiesSet方法 <-- beanPostProcessor前置处理 <——
 * ｜
 * ｜
 * --> beanPostProcess 后置处理 --> 注册必要的Destruction相关回调接口 --> 使用中 --> 是否实现 DisposableBean接口 --> 是否配置默认的destroy方法
 *
 * @author lgc
 * @create 2020-01-13 10:40 上午
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor, InstantiationAwareBeanPostProcessor, SmartInstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean: " + bean + "name: " + "初始化" + beanName + "之前");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean: " + bean + "name:" + "初始化" + beanName + "之后");
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("beanClass: " + beanClass + "beanName: " + "生成实例" + beanName + "之前");
        return beanClass;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("beanClass: " + bean + "beanName: " + "生成实例" + beanName + "之后");
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("propertyValues: " + pvs + "bean: " + bean + "beanName: " + "处理" + beanName + "变量");
        return null;
    }

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("smart predictBeanType");
        return null;
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("smart determineCandidateConstructors");
        return new Constructor[0];
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        System.out.println("smart getEarlyBeanReference->resolve loop reference");
        return null;
    }

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        System.out.println("bean: " + bean + "beanName: " + "销毁" + beanName + "bean之前");
    }

    @Override
    public boolean requiresDestruction(Object bean) {
        System.out.println();
        return false;
    }

    @Component
    static class A {
        @Autowired
        B b;
    }

    @Component
    static class B {
        @Autowired
        A a;
    }
}
