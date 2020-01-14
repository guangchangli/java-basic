package com.lgc.pattern.proxy;

import com.lgc.pattern.BaseDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 *   代理对象要实现接口
 * @author lgc
 * @create 2020-01-14 10:29 上午
 **/
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("111");
                        Object invoke = method.invoke(target, args);
                        System.out.println("222");
                        return invoke;
                    }
                }
        );
    }

    public static void main(String[] args) {
        StaticDao target = new StaticDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        BaseDao proxy = (BaseDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());
        // 执行方法   【代理对象】
        proxy.base();
    }
}
