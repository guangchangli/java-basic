package com.lgc.pattern.proxy;

import com.lgc.pattern.BaseDao;

/**
 * jdk动态代理
 * 代理对象要实现接口
 *
 * @author lgc
 **/
public class TestJdkProxy {

    public static void main(String[] args) {
        //真实角色
        StaticDao target = new StaticDao();
        // 给目标对象，创建代理对象
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(target);
        BaseDao proxyInstance = (BaseDao) myInvocationHandler.getProxyInstance();
        proxyInstance.base();
    }
}
