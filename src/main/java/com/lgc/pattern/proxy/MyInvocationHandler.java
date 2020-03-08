package com.lgc.pattern.proxy;

import com.lgc.pattern.BaseDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lgc
 * @create 2020-01-14 11:07 上午
 **/
public class MyInvocationHandler implements InvocationHandler {

    BaseDao baseDao;

    public MyInvocationHandler(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(baseDao, args);
    }

    /**
     * 创建代理对象
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), baseDao.getClass().getInterfaces(), this);
    }
}
