package com.lgc.pattern.proxy.cglib;

import com.lgc.pattern.proxy.StaticDao;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @Configuation cglib 代理产生一个子类
 * getBeanDefinitions 遍历判断是否有 Configuration 注解 生成代理类 extend 原始对象
 * invokeSupper
 * @author lgc
 **/
public class CglibDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(StaticDao.class);
        enhancer.setCallback(new MyMethodInterceptor());
        StaticDao staticDao= (StaticDao) enhancer.create();
        staticDao.base();
    }
}
